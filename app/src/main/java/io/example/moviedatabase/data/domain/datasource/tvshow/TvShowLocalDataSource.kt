package io.example.moviedatabase.data.domain.datasource.tvshow

import io.example.moviedatabase.data.model.tvshow.TvShowModel

interface TvShowLocalDataSource {
    suspend fun getTvShow(): List<TvShowModel>?
    suspend fun saveTvShow(tvShowModel: List<TvShowModel>)
    suspend fun clearAll()
}