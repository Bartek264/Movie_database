package io.example.moviedatabase.domain.movie

import io.example.moviedatabase.data.model.movie.MovieModel

class GetMovieUsecase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<MovieModel>? = movieRepository.getMovies()

}