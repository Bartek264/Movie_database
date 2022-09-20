package io.example.moviedatabase.data.model.tvshow

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshow_table")
data class TvShowModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val backdrop_path: String? = null,
    val first_air_date: String? = null,
    val name: String? = null,
    val original_language: String? = null,
    val original_name: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)