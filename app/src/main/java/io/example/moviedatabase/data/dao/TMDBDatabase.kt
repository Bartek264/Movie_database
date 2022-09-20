package io.example.moviedatabase.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import io.example.moviedatabase.data.dao.movie.MovieDao
import io.example.moviedatabase.data.dao.people.PeopleDao
import io.example.moviedatabase.data.dao.tvshow.TvShowDao
import io.example.moviedatabase.data.model.movie.MovieModel
import io.example.moviedatabase.data.model.people.PeopleModel
import io.example.moviedatabase.data.model.tvshow.TvShowModel

@Database(entities = [MovieModel::class, TvShowModel::class, PeopleModel::class],
    version = 1,
    exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun peopleDao(): PeopleDao
    abstract fun tvShowDao(): TvShowDao
}