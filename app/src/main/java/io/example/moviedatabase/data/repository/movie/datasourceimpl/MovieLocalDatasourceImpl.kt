package io.example.moviedatabase.data.repository.movie.datasourceimpl

import io.example.moviedatabase.data.model.movie.MovieModel
import io.example.moviedatabase.data.repository.movie.datasource.MovieLocalDatasource
import io.example.moviedatabase.data.room.dao.MovieDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val movieDao: MovieDao): MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<MovieModel> = movieDao.getAllMovies()

    override suspend fun setMoviesToDB(movieModel: List<MovieModel>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movieModel)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch { movieDao.deleteAllMovies() }
    }
}