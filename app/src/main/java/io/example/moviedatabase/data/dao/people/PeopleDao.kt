package io.example.moviedatabase.data.dao.people

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.example.moviedatabase.data.model.people.PeopleModel

@Dao
interface PeopleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePeople(model: List<PeopleModel>)

    @Query("SELECT * FROM people_table")
    suspend fun getPeople(): List<PeopleModel>

    @Query("DELETE FROM people_table")
    suspend fun deleteAll()

}