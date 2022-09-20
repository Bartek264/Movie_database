package io.example.moviedatabase.di.database

import dagger.Module
import dagger.Provides
import io.example.moviedatabase.data.api.TMDBService
import io.example.moviedatabase.data.domain.datasource.movie.MovieRemoteDatasource
import io.example.moviedatabase.data.domain.datasource.movie.impl.MovieRemoteDatasourceImpl
import io.example.moviedatabase.data.domain.datasource.people.PeopleRemoteDataSource
import io.example.moviedatabase.data.domain.datasource.people.impl.PeopleRemoteDataSourceImpl
import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowRemoteDataSource
import io.example.moviedatabase.data.domain.datasource.tvshow.impl.TvShowRemoteDataSourceImpl
import javax.inject.Singleton


/**
 * @param apiKey wejściowa wartość bo jest to konstruktor datasource
 * @see MovieRemoteDatasourceImpl.getMovies
 */

@Module
class RemoteDataModule(private val apiKey: String) {

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource = MovieRemoteDatasourceImpl(tmdbService, apiKey)

    @Provides
    @Singleton
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource = TvShowRemoteDataSourceImpl(tmdbService, apiKey)

    @Provides
    @Singleton
    fun providePeopleRemoteDataSource(tmdbService: TMDBService): PeopleRemoteDataSource = PeopleRemoteDataSourceImpl(tmdbService, apiKey)

}