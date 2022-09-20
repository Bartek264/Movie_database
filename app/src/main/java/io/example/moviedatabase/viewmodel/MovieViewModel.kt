package io.example.moviedatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.example.moviedatabase.data.domain.usecase.movie.GetMovieUseCase
import io.example.moviedatabase.data.domain.usecase.movie.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }

}