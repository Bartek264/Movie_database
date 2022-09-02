package io.example.moviedatabase.domain.people

import io.example.moviedatabase.data.model.people.PeopleModel

class GetPeopleUsecase(private val peopleRepository: PeopleRepository) {
    suspend fun getPeople(): List<PeopleModel>? = peopleRepository.getPeople()
}