package io.example.moviedatabase.data.domain.usecase.tvshow

import io.example.moviedatabase.data.model.tvshow.TvShowModel

interface TvShowRepository {
    suspend fun getTvShow(): List<TvShowModel>?
    suspend fun updateTvShow(): List<TvShowModel>?
}