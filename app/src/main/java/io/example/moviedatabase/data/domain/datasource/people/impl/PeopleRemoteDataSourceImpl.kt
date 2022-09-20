package io.example.moviedatabase.data.domain.datasource.people.impl

import io.example.moviedatabase.data.api.TMDBService
import io.example.moviedatabase.data.domain.datasource.people.PeopleRemoteDataSource
import io.example.moviedatabase.data.model.people.PeopleModelList
import retrofit2.Response

class PeopleRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String): PeopleRemoteDataSource {
    override suspend fun getPeopleFromApi(): Response<PeopleModelList> = tmdbService.getPopularPeople(apiKey)
}