package io.example.moviedatabase.viewmodel.repository

import io.example.moviedatabase.data.domain.usecase.people.PeopleRepository
import io.example.moviedatabase.data.model.people.PeopleModel

class FakePeopleRepository: PeopleRepository {

    private var peopleList = ArrayList<PeopleModel>()

    init {
        peopleList.add(PeopleModel(1, false, 1, "en", "en", 2.1, "path"))
        peopleList.add(PeopleModel(2, false, 3, "en", "en", 3.1, "path"))
        peopleList.add(PeopleModel(3, false, 2, "en", "en", 4.1, "path"))
    }

    override suspend fun getPeople(): List<PeopleModel>? = peopleList

    override suspend fun updatePeople(): List<PeopleModel>? {
        peopleList.clear()
        peopleList.add(PeopleModel(4, false, 1, "en", "en", 5.1, "path"))
        peopleList.add(PeopleModel(5, false, 3, "en", "en", 6.1, "path"))
        peopleList.add(PeopleModel(6, false, 2, "en", "en", 7.1, "path"))
        return peopleList
    }


}