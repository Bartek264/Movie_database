package io.example.moviedatabase.data.domain.usecase.movie

import io.example.moviedatabase.data.model.movie.MovieModel

class GetMovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<MovieModel>? = movieRepository.getMovies()

}