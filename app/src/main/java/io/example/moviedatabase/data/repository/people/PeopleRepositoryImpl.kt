package io.example.moviedatabase.data.repository.people

import android.util.Log
import io.example.moviedatabase.data.model.people.PeopleModel
import io.example.moviedatabase.data.repository.people.datasource.PeopleCacheDatasource
import io.example.moviedatabase.data.repository.people.datasource.PeopleLocalDatasource
import io.example.moviedatabase.data.repository.people.datasource.PeopleRemoteDatasource
import io.example.moviedatabase.domain.people.PeopleRepository

class PeopleRepositoryImpl(
    private val peopleLocalDatasource: PeopleLocalDatasource,
    private val peopleRemoteDatasource: PeopleRemoteDatasource,
    private val peopleCacheDatasource: PeopleCacheDatasource): PeopleRepository {

    override suspend fun getPeople(): List<PeopleModel> = getPeopleFromCache()

    override suspend fun updatePeople(): List<PeopleModel> {
        val peopleList = listOf<PeopleModel>()

        peopleLocalDatasource.clearAll()
        peopleLocalDatasource.setPeopleToDB(peopleList)
        peopleCacheDatasource.savePeopleFromCache(peopleList)

        return peopleList
    }

    suspend fun getPeopleFromAPI(): List<PeopleModel> {
        var peopleList = listOf<PeopleModel>()

        try {
            val response = peopleRemoteDatasource.getPeople().body()
            if(response != null) {
                peopleList = response.peopleModel
            }
        } catch (e: Exception) {
            Log.v(this::class.simpleName, "getPeopleFromAPI fail: ${e.message}")
        }

        return peopleList
    }

    suspend fun getPeopleFromDB(): List<PeopleModel> {
        var peopleList = listOf<PeopleModel>()

        try {
            peopleList = peopleLocalDatasource.getPeopleFromDB()
        } catch (e: Exception) {
            Log.v(this::class.simpleName, "getPeopleFromDB fail: ${e.message}")
        }

        return if (peopleList.isNotEmpty()) {
            peopleList
        } else {
            peopleList = getPeopleFromAPI()
            peopleLocalDatasource.setPeopleToDB(peopleList)
            peopleList
        }

    }

    suspend fun getPeopleFromCache(): List<PeopleModel> {
        var peopleList = listOf<PeopleModel>()

        try {
            peopleList = peopleCacheDatasource.getPeopleFromCache()
        } catch (e: Exception) {
            Log.v(this::class.simpleName, "getPeopleFromCache fail: ${e.message}")
        }

        return if (peopleList.isNotEmpty()) {
            peopleList
        } else {
            peopleList = getPeopleFromDB()
            peopleCacheDatasource.savePeopleFromCache(peopleList)
            peopleList
        }
    }

}