package io.example.moviedatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.example.moviedatabase.data.domain.usecase.people.GetPeopleUseCase
import io.example.moviedatabase.data.domain.usecase.people.UpdatePeopleUseCase

class PeopleViewModel (
    private val getPeopleUseCase: GetPeopleUseCase,
    private val updatePeopleUseCase: UpdatePeopleUseCase
): ViewModel() {

    fun getPeople() = liveData {
        val movieList = getPeopleUseCase.execute()
        emit(movieList)
    }

    fun updatePeople() = liveData {
        val movieList = updatePeopleUseCase.execute()
        emit(movieList)
    }
}
