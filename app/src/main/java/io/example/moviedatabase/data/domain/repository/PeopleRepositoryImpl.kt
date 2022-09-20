package io.example.moviedatabase.data.domain.repository

import android.util.Log
import io.example.moviedatabase.data.domain.datasource.people.PeopleCacheDataSource
import io.example.moviedatabase.data.domain.datasource.people.PeopleLocalDataSource
import io.example.moviedatabase.data.domain.datasource.people.PeopleRemoteDataSource
import io.example.moviedatabase.data.domain.usecase.people.PeopleRepository
import io.example.moviedatabase.data.model.people.PeopleModel

class PeopleRepositoryImpl(
    private val peopleRemoteDataSource: PeopleRemoteDataSource,
    private val peopleLocalDataSource: PeopleLocalDataSource,
    private val peopleCacheDataSource: PeopleCacheDataSource
): PeopleRepository {
    override suspend fun getPeople(): List<PeopleModel> = getPeopleListFromCache()

    override suspend fun updatePeople(): List<PeopleModel> {
        val newPeopleList = getPeopleListFromApi()
        peopleLocalDataSource.clearAll()
        peopleLocalDataSource.savePeopleToDB(newPeopleList)
        peopleCacheDataSource.savePeopleToCache(newPeopleList)
        return newPeopleList
    }

    suspend fun getPeopleListFromApi(): List<PeopleModel> {
        var peopleList = listOf<PeopleModel>()

        try {
            val response = peopleRemoteDataSource.getPeopleFromApi()
            val body = response.body()

            if (body != null) {
                peopleList = body.results!!
            }
        } catch (e: Exception) {
            Log.v(this::class.simpleName, "getPeopleListFromApi ERROR: ${e.message}")
        }

        return peopleList
    }

    suspend fun getPeopleListFromDB(): List<PeopleModel> {
        var peopleList = listOf<PeopleModel>()

        try {
            val response = peopleLocalDataSource.getPeopleFromDB()
            peopleList = response

        } catch (e: Exception) {
            Log.v(this::class.simpleName, "getPeopleListFromDB ERROR: ${e.message}")
        }

        if (peopleList.isNotEmpty()) {
            return peopleList
        } else {
            peopleList = getPeopleListFromApi()
            peopleLocalDataSource.savePeopleToDB(peopleList)
        }

        return peopleList
    }

    suspend fun getPeopleListFromCache(): List<PeopleModel> {
        var peopleList = listOf<PeopleModel>()

        try {
            val response = peopleCacheDataSource.getPeopleFromCache()
            peopleList = response

        } catch (e: Exception) {
            Log.v(this::class.simpleName, "getPeopleListFromCache ERROR: ${e.message}")
        }

        if (peopleList.isNotEmpty()) {
            return peopleList
        } else {
            peopleList = getPeopleListFromDB()
            peopleCacheDataSource.savePeopleToCache(peopleList)
        }

        return peopleList
    }

}