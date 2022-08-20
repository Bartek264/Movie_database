package io.example.moviedatabase.data.model.people


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "famous_people")
data class PeopleModel(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("gender")
    val gender: Int,
    @SerializedName("known_for")
    val knownFor: List<PeopleKnownForModel>,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String
)