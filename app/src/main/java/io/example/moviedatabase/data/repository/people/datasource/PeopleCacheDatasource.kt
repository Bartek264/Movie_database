package io.example.moviedatabase.data.repository.people.datasource

import io.example.moviedatabase.data.model.people.PeopleModel

interface PeopleCacheDatasource {
    suspend fun getPeopleFromCache(): List<PeopleModel>
    suspend fun savePeopleFromCache(peopleModel: List<PeopleModel>)
}