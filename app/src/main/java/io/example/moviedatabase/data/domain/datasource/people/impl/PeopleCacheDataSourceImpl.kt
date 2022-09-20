package io.example.moviedatabase.data.domain.datasource.people.impl

import io.example.moviedatabase.data.domain.datasource.people.PeopleCacheDataSource
import io.example.moviedatabase.data.model.people.PeopleModel

class PeopleCacheDataSourceImpl: PeopleCacheDataSource {

    private var peopleList = arrayListOf<PeopleModel>()

    override suspend fun getPeopleFromCache(): List<PeopleModel> = peopleList

    override suspend fun savePeopleToCache(model: List<PeopleModel>) {
        peopleList.clear()
        peopleList = ArrayList(model)
    }
}