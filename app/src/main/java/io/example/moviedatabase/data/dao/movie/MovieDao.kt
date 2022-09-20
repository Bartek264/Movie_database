package io.example.moviedatabase.data.dao.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.example.moviedatabase.data.model.movie.MovieModel

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movie: List<MovieModel>)

    @Query("SELECT * FROM movie_table")
    suspend fun getMovies(): List<MovieModel>

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()

}