package io.example.moviedatabase.data.domain.datasource.tvshow

import io.example.moviedatabase.data.model.tvshow.TvShowModel

interface TvShowCacheDataSource {
    suspend fun getTvShowFromDB(): List<TvShowModel>
    suspend fun saveTvShowToDB(tvShowModel: List<TvShowModel>)
}