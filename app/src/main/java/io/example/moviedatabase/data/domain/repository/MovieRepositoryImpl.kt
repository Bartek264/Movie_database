package io.example.moviedatabase.data.domain.repository

import android.util.Log
import io.example.moviedatabase.data.domain.datasource.movie.MovieCacheDatasource
import io.example.moviedatabase.data.domain.datasource.movie.MovieLocalDataSource
import io.example.moviedatabase.data.domain.datasource.movie.MovieRemoteDatasource
import io.example.moviedatabase.data.domain.usecase.movie.MovieRepository
import io.example.moviedatabase.data.model.movie.MovieModel

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDataSource,
    private val movieCacheDatasource: MovieCacheDatasource
): MovieRepository {

    override suspend fun getMovies(): List<MovieModel> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<MovieModel> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<MovieModel> {
        var movieList = listOf<MovieModel>()

        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.results!!
            }
        } catch (exception: Exception) {
            Log.v(this::class.simpleName, "getMoviesFromAPI ERROR: ${exception.message}")
        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<MovieModel> {
        var movieList = listOf<MovieModel>()

        try {
            val response = movieLocalDatasource.getMoviesFromDB()
            if (response != null) {
                movieList = response
            }
        } catch (exception: Exception) {
            Log.v(this::class.simpleName, "getMoviesFromDB ERROR: ${exception.message}")
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<MovieModel> {
        var movieList = listOf<MovieModel>()

        try {
            val response = movieCacheDatasource.getMoviesFromCache()
            movieList = response
        } catch (exception: Exception) {
            Log.v(this::class.simpleName, "getMoviesFromCache ERROR: ${exception.message}")
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