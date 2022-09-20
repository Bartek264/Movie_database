package io.example.moviedatabase.di.database

import dagger.Module
import dagger.Provides
import io.example.moviedatabase.data.dao.movie.MovieDao
import io.example.moviedatabase.data.dao.people.PeopleDao
import io.example.moviedatabase.data.dao.tvshow.TvShowDao
import io.example.moviedatabase.data.domain.datasource.movie.MovieLocalDataSource
import io.example.moviedatabase.data.domain.datasource.movie.impl.MovieLocalDatasourceImpl
import io.example.moviedatabase.data.domain.datasource.people.PeopleLocalDataSource
import io.example.moviedatabase.data.domain.datasource.people.impl.PeopleLocalDataSourceImpl
import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowLocalDataSource
import io.example.moviedatabase.data.domain.datasource.tvshow.impl.TvShowLocalDataSourceImpl
import javax.inject.Singleton

/**
 * Odwołujemy się do DataSource lokalny baz danych, wejściowe Dao jest pobierane z
 * @see DatabaseModule
 */

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun providerMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource = MovieLocalDatasourceImpl(movieDao)

    @Provides
    @Singleton
    fun providerTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource = TvShowLocalDataSourceImpl(tvShowDao)

    @Provides
    @Singleton
    fun providerPeopleLocalDataSource(peopleDao: PeopleDao): PeopleLocalDataSource = PeopleLocalDataSourceImpl(peopleDao)

}