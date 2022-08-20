package io.example.moviedatabase.data.model


import com.google.gson.annotations.SerializedName

data class PeopleModelList(
    @SerializedName("people_model")
    val peopleModel: List<PeopleModel>
)