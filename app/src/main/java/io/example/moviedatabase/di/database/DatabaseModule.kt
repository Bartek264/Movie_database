package io.example.moviedatabase.di.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.example.moviedatabase.data.dao.TMDBDatabase
import io.example.moviedatabase.data.dao.movie.MovieDao
import io.example.moviedatabase.data.dao.people.PeopleDao
import io.example.moviedatabase.data.dao.tvshow.TvShowDao
import javax.inject.Singleton

/**
 *  Główny moduł do DB dzięki któremu łączymy się z instniejącymi bazami danych
 */

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideMovieDataBase(context: Context): TMDBDatabase = Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdb_client").build()

    @Provides
    @Singleton
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao = tmdbDatabase.movieDao()

    @Provides
    @Singleton
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao = tmdbDatabase.tvShowDao()

    @Provides
    @Singleton
    fun providePeopleDao(tmdbDatabase: TMDBDatabase): PeopleDao = tmdbDatabase.peopleDao()

}