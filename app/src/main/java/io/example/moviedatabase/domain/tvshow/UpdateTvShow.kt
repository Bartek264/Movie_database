package io.example.moviedatabase.domain.tvshow

import io.example.moviedatabase.data.model.tvshow.TvShowModel

class UpdateTvShow(private val tvShowRepository: TvShowRepository) {
    suspend fun updateTvShow(): List<TvShowModel>? = tvShowRepository.updateTvShow()
}