package io.example.moviedatabase.data.domain.usecase.movie

import io.example.moviedatabase.data.model.movie.MovieModel

interface MovieRepository {
    suspend fun getMovies(): List<MovieModel>?
    suspend fun updateMovies(): List<MovieModel>?
}