package io.example.moviedatabase.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import io.example.moviedatabase.data.model.movie.MovieModel
import io.example.moviedatabase.data.model.people.PeopleModel
import io.example.moviedatabase.data.model.tvshow.TvShowModel
import io.example.moviedatabase.data.room.dao.MovieDao
import io.example.moviedatabase.data.room.dao.PeopleDao

@Database(entities = [MovieModel::class, PeopleModel::class, TvShowModel::class], version = 1, exportSchema = false)
abstract class TMDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun peopleDao(): PeopleDao
    abstract fun tvShowDao(): TvShowModel
}