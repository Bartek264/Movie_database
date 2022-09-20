package io.example.moviedatabase.data.domain.datasource.movie.impl

import io.example.moviedatabase.data.dao.movie.MovieDao
import io.example.moviedatabase.data.domain.datasource.movie.MovieLocalDataSource
import io.example.moviedatabase.data.model.movie.MovieModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @return operacje związane z query na lokalnej bazie danych
 * @see MovieDao
 */
class MovieLocalDatasourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<MovieModel>? = movieDao.getMovies()

    override suspend fun saveMoviesToDB(model: List<MovieModel>) {
        CoroutineScope(Dispatchers.IO).launch { movieDao.saveMovies(model) }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch { movieDao.deleteAllMovies() }
    }
}