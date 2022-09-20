package io.example.moviedatabase.di.core

import dagger.Module
import dagger.Provides
import io.example.moviedatabase.data.domain.datasource.movie.MovieCacheDatasource
import io.example.moviedatabase.data.domain.datasource.movie.MovieLocalDataSource
import io.example.moviedatabase.data.domain.datasource.movie.MovieRemoteDatasource
import io.example.moviedatabase.data.domain.datasource.people.PeopleCacheDataSource
import io.example.moviedatabase.data.domain.datasource.people.PeopleLocalDataSource
import io.example.moviedatabase.data.domain.datasource.people.PeopleRemoteDataSource
import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowCacheDataSource
import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowLocalDataSource
import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowRemoteDataSource
import io.example.moviedatabase.data.domain.repository.MovieRepositoryImpl
import io.example.moviedatabase.data.domain.repository.PeopleRepositoryImpl
import io.example.moviedatabase.data.domain.repository.TvShowRepositoryImpl
import io.example.moviedatabase.data.domain.usecase.movie.MovieRepository
import io.example.moviedatabase.data.domain.usecase.people.PeopleRepository
import io.example.moviedatabase.data.domain.usecase.tvshow.TvShowRepository
import javax.inject.Singleton

/**
 * Lacznie modułów z pakietu database
 * @see RemoteDataModule
 */

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository = MovieRepositoryImpl(movieRemoteDatasource, movieLocalDataSource, movieCacheDatasource)

    @Provides
    @Singleton
    fun providesTvSowRepository(
        tvShowRemoteDatasource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository = TvShowRepositoryImpl(tvShowRemoteDatasource, tvShowLocalDataSource, tvShowCacheDataSource)

    @Provides
    @Singleton
    fun providesPeopleRepository(
        peopleRemoteDataSource: PeopleRemoteDataSource,
        peopleLocalDataSource: PeopleLocalDataSource,
        peopleCacheDataSource: PeopleCacheDataSource
    ): PeopleRepository = PeopleRepositoryImpl(peopleRemoteDataSource, peopleLocalDataSource, peopleCacheDataSource)



}