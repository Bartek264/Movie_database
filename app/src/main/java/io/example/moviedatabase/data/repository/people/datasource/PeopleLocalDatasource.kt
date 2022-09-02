package io.example.moviedatabase.data.repository.people.datasource

import io.example.moviedatabase.data.model.people.PeopleModel

interface PeopleLocalDatasource {
    suspend fun getPeopleFromDB(): List<PeopleModel>
    suspend fun setPeopleToDB(people: List<PeopleModel>)
    suspend fun clearAll()
}