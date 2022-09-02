package io.example.moviedatabase.data.repository.people.datasourceimpl

import io.example.moviedatabase.data.model.people.PeopleModel
import io.example.moviedatabase.data.repository.people.datasource.PeopleLocalDatasource
import io.example.moviedatabase.data.room.dao.PeopleDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeopleLocalDatasourceImpl(private val peopleDao: PeopleDao): PeopleLocalDatasource {
    override suspend fun getPeopleFromDB(): List<PeopleModel> = peopleDao.getAllPeoples()

    override suspend fun setPeopleToDB(people: List<PeopleModel>) {
        CoroutineScope(Dispatchers.IO).launch { peopleDao.savePeoples(people) }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch { peopleDao.deleteAllPeoples() }
    }
}