package io.example.moviedatabase.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.example.moviedatabase.data.model.people.PeopleModel

@Dao
interface PeopleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePeoples(peoples: List<PeopleModel>)

    @Query("DELETE FROM famous_people")
    suspend fun deleteAllPeoples()

    @Query("SELECT * FROM famous_people")
    suspend fun getAllPeoples(peoples: List<PeopleModel>)

}