package io.example.moviedatabase.data.dao.tvshow

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.example.moviedatabase.data.model.tvshow.TvShowModel

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(model: List<TvShowModel>)

    @Query("SELECT * FROM tvshow_table")
    suspend fun getTvShow(): List<TvShowModel>?

    @Query("DELETE FROM tvshow_table")
    suspend fun deleteAll()

}