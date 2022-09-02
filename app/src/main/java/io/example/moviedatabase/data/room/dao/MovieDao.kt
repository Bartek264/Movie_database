package io.example.moviedatabase.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.example.moviedatabase.data.model.movie.MovieModel

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //Replace old data with new
    suspend fun saveMovies(movies: List<MovieModel>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies(): List<MovieModel>
}