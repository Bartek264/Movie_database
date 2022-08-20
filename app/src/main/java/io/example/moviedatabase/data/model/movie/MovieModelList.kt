package io.example.moviedatabase.data.model.movie


import com.google.gson.annotations.SerializedName

data class MovieModelList(
    @SerializedName("movie_model")
    val movieModel: List<MovieModel>
)