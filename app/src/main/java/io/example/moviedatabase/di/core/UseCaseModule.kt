package io.example.moviedatabase.di.core

import dagger.Module
import dagger.Provides
import io.example.moviedatabase.data.domain.usecase.movie.GetMovieUseCase
import io.example.moviedatabase.data.domain.usecase.movie.MovieRepository
import io.example.moviedatabase.data.domain.usecase.movie.UpdateMovieUseCase
import io.example.moviedatabase.data.domain.usecase.people.GetPeopleUseCase
import io.example.moviedatabase.data.domain.usecase.people.PeopleRepository
import io.example.moviedatabase.data.domain.usecase.people.UpdatePeopleUseCase
import io.example.moviedatabase.data.domain.usecase.tvshow.GetTvShowUseCase
import io.example.moviedatabase.data.domain.usecase.tvshow.TvShowRepository
import io.example.moviedatabase.data.domain.usecase.tvshow.UpdateTvShowUseCase

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMovieUseCase = GetMovieUseCase(movieRepository)

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMovieUseCase = UpdateMovieUseCase(movieRepository)

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase = GetTvShowUseCase(tvShowRepository)

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase = UpdateTvShowUseCase(tvShowRepository)

    @Provides
    fun provideGetPeopleUseCase(peopleRepository: PeopleRepository): GetPeopleUseCase = GetPeopleUseCase(peopleRepository)

    @Provides
    fun provideUpdatePeopleUseCase(peopleRepository: PeopleRepository): UpdatePeopleUseCase = UpdatePeopleUseCase(peopleRepository)

}