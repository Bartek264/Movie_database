package io.example.moviedatabase.data.domain.datasource.people

import io.example.moviedatabase.data.model.people.PeopleModel

interface PeopleLocalDataSource {
    suspend fun getPeopleFromDB(): List<PeopleModel>
    suspend fun savePeopleToDB(model: List<PeopleModel>)
    suspend fun clearAll()
}