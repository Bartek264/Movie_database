package io.example.moviedatabase.domain.people

import io.example.moviedatabase.data.model.people.PeopleModel

interface PeopleRepository {
    suspend fun getPeople(): List<PeopleModel>?
    suspend fun updatePeople(): List<PeopleModel>?
}