package io.example.moviedatabase.data.domain.usecase.people

import io.example.moviedatabase.data.model.people.PeopleModel

interface PeopleRepository {
    suspend fun getPeople(): List<PeopleModel>?
    suspend fun updatePeople(): List<PeopleModel>?
}