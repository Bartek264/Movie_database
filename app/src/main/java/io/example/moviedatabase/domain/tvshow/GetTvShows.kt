package io.example.moviedatabase.domain.tvshow

import io.example.moviedatabase.data.model.tvshow.TvShowModel

class GetTvShows(private val tvShowRepository: TvShowRepository) {
    suspend fun getTvShows(): List<TvShowModel>? = tvShowRepository.getTvShow()
}