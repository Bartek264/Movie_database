package io.example.moviedatabase.data.model.people


import com.google.gson.annotations.SerializedName

data class PeopleModelList(
    @SerializedName("people_model")
    val peopleModel: List<PeopleModel>
)