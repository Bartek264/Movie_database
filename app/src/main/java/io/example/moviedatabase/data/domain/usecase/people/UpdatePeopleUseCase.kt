package io.example.moviedatabase.data.domain.usecase.people

import io.example.moviedatabase.data.model.people.PeopleModel

class UpdatePeopleUseCase(private val peopleRepository: PeopleRepository) {
    suspend fun execute(): List<PeopleModel>? = peopleRepository.updatePeople()
}