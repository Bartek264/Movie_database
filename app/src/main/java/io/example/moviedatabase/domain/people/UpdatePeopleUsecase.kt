package io.example.moviedatabase.domain.people

class UpdatePeopleUsecase(private val peopleRepository: PeopleRepository) {
    suspend fun updatePeople() = peopleRepository.updatePeople()
}