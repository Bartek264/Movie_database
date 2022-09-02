package io.example.moviedatabase.domain.movie

import io.example.moviedatabase.data.model.movie.MovieModel

class UpdateMovieUsercase(private val movieRepository: MovieRepository) {
    suspend fun updateMovies(): List<MovieModel>? = movieRepository.updateMovies()
}