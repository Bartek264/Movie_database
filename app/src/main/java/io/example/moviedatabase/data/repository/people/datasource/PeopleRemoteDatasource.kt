package io.example.moviedatabase.data.repository.people.datasource

import io.example.moviedatabase.data.model.people.PeopleModelList
import retrofit2.Response

interface PeopleRemoteDatasource {
    suspend fun getPeople(): Response<PeopleModelList>
}