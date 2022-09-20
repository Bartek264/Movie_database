package io.example.moviedatabase.data.domain.datasource.people

import io.example.moviedatabase.data.model.people.PeopleModel

interface PeopleCacheDataSource {
    suspend fun getPeopleFromCache(): List<PeopleModel>
    suspend fun savePeopleToCache(model: List<PeopleModel>)
}