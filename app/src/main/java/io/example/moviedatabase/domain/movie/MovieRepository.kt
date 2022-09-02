package io.example.moviedatabase.domain.movie

import io.example.moviedatabase.data.model.movie.MovieModel

// Repository interface for movie
interface MovieRepository {

    suspend fun getMovies(): List<MovieModel>?
    suspend fun updateMovies(): List<MovieModel>?
}