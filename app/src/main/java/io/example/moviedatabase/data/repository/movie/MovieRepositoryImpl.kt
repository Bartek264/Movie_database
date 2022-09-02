package io.example.moviedatabase.data.repository.movie

import android.util.Log
import io.example.moviedatabase.data.model.movie.MovieModel
import io.example.moviedatabase.data.repository.movie.datasource.MovieCacheDatasource
import io.example.moviedatabase.data.repository.movie.datasource.MovieLocalDatasource
import io.example.moviedatabase.data.repository.movie.datasource.MovieRemoteDatasource
import io.example.moviedatabase.domain.movie.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDatasource: MovieCacheDatasource
): MovieRepository {
    override suspend fun getMovies(): List<MovieModel> = getMoviesFromCache()

    override suspend fun updateMovies(): List<MovieModel> {
        val newListOfMovies = getMoviesFromAPI()

        movieLocalDatasource.clearAll()
        movieLocalDatasource.setMoviesToDB(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<MovieModel> {
        var movieList = listOf<MovieModel>()

        try {
            val response = movieRemoteDatasource.getMovies().body()
            if (response != null) {
                movieList = response.movieModel
            }
        } catch (e: Exception) {
            Log.v(this::class.java.simpleName, "getMoviesFromAPI: ${e.message}")
        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<MovieModel> {
        var movieList = listOf<MovieModel>()

        try {
            movieList = movieLocalDatasource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.v(this::class.java.simpleName, "getMoviesFromDB: ${e.message}")
        }
        if (movieList.isNotEmpty()){
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDatasource.setMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<MovieModel> {
        var movieList = listOf<MovieModel>()

        try {
            movieList - movieCacheDatasource.getMoviesFromCache().toSet()
        } catch (e: Exception) {
            Log.v(this::class.java.simpleName, "getMoviesFromAPI: ${e.message}")
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDatasource.saveMoviesToCache(movieList)
        }

        return movieList
    }

}