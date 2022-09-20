package io.example.moviedatabase.di.scope.movie

import dagger.Module
import dagger.Provides
import io.example.moviedatabase.data.domain.usecase.movie.GetMovieUseCase
import io.example.moviedatabase.data.domain.usecase.movie.UpdateMovieUseCase
import io.example.moviedatabase.viewmodel.MovieViewModelFactory

@Module
class MovieModel {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory = MovieViewModelFactory(getMovieUseCase, updateMovieUseCase)

}