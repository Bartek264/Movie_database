package io.example.moviedatabase.data.repository.people.datasourceimpl

import io.example.moviedatabase.data.model.people.PeopleModel
import io.example.moviedatabase.data.repository.people.datasource.PeopleCacheDatasource

class PeopleCacheDatasourceImpl: PeopleCacheDatasource {
    private var peopleList = ArrayList<PeopleModel>()

    override suspend fun getPeopleFromCache(): List<PeopleModel>  = peopleList

    override suspend fun savePeopleFromCache(peopleModel: List<PeopleModel>) {
        peopleList.clear()
        peopleList = ArrayList(peopleModel)
    }
}