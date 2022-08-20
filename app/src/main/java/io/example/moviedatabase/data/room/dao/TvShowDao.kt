package io.example.moviedatabase.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.example.moviedatabase.data.model.tvshow.TvShowModel

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShowModel>)

    @Query("DELETE FROM tvshow_table")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM tvshow_table")
    suspend fun getAllTvShow(tvShows: List<TvShowModel>)
}