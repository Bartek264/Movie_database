package io.example.moviedatabase.di.database

import dagger.Module
import dagger.Provides
import io.example.moviedatabase.data.domain.datasource.movie.MovieCacheDatasource
import io.example.moviedatabase.data.domain.datasource.movie.impl.MovieCacheDatasourceImpl
import io.example.moviedatabase.data.domain.datasource.people.PeopleCacheDataSource
import io.example.moviedatabase.data.domain.datasource.people.impl.PeopleCacheDataSourceImpl
import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowCacheDataSource
import io.example.moviedatabase.data.domain.datasource.tvshow.impl.TvShowCacheDataSourceImpl
import javax.inject.Singleton

/**
 * Odwołujemy się do CacheDataSource danych repo
 */

@Module
class CacheDataModule {

    @Provides
    @Singleton
    fun providerMovieCacheDataSource(): MovieCacheDatasource = MovieCacheDatasourceImpl()

    @Provides
    @Singleton
    fun providerTvShowCacheDataSource(): TvShowCacheDataSource = TvShowCacheDataSourceImpl()

    @Provides
    @Singleton
    fun providerPeopleCacheDataSource(): PeopleCacheDataSource = PeopleCacheDataSourceImpl()

}