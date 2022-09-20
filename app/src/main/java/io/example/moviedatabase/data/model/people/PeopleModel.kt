package io.example.moviedatabase.data.model.people

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people_table")
data class PeopleModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val adult: Boolean? = null,
    val gender: Int? = null,
    val known_for_department: String? = null,
    val name: String? = null,
    val popularity: Double? = null,
    val profile_path: String? = null
)