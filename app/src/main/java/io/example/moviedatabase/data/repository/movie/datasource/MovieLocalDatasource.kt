package io.example.moviedatabase.data.repository.movie.datasource

import io.example.moviedatabase.data.model.movie.MovieModel

interface MovieLocalDatasource {
    suspend fun getMoviesFromDB(): List<MovieModel>
    suspend fun setMoviesToDB(movieModel: List<MovieModel>)
    suspend fun clearAll()
}