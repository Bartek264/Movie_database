package io.example.moviedatabase.data.domain.datasource.movie

import io.example.moviedatabase.data.model.movie.MovieModel

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<MovieModel>?
    suspend fun saveMoviesToDB(model: List<MovieModel>)
    suspend fun clearAll()
}