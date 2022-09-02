package io.example.moviedatabase.data.repository.movie.datasource

import io.example.moviedatabase.data.model.movie.MovieModel

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache(): List<MovieModel>
    suspend fun saveMoviesToCache(model: List<MovieModel>)
}