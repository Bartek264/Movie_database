package io.example.moviedatabase.data.domain.datasource.people.impl

import io.example.moviedatabase.data.dao.people.PeopleDao
import io.example.moviedatabase.data.domain.datasource.people.PeopleLocalDataSource
import io.example.moviedatabase.data.model.people.PeopleModel

class PeopleLocalDataSourceImpl(private val peopleDao: PeopleDao): PeopleLocalDataSource {
    override suspend fun getPeopleFromDB(): List<PeopleModel> = peopleDao.getPeople()

    override suspend fun savePeopleToDB(model: List<PeopleModel>) {
        peopleDao.savePeople(model)
    }

    override suspend fun clearAll() {
        peopleDao.deleteAll()
    }
}