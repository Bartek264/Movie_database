package io.example.moviedatabase.data.domain.datasource.people

import io.example.moviedatabase.data.model.people.PeopleModelList
import retrofit2.Response

interface PeopleRemoteDataSource {
    suspend fun getPeopleFromApi(): Response<PeopleModelList>
}