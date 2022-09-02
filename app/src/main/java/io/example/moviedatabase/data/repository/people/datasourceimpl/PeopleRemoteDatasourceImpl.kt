package io.example.moviedatabase.data.repository.people.datasourceimpl

import io.example.moviedatabase.data.api.TMDBService
import io.example.moviedatabase.data.model.people.PeopleModelList
import retrofit2.Response

class PeopleRemoteDatasourceImpl(private val tmdbService: TMDBService,
                                 private val apiKey: String) {
    suspend fun getPeople(): Response<PeopleModelList> = tmdbService.getPopularPeople(apiKey)
}