package io.example.moviedatabase.data.domain.usecase.tvshow

import io.example.moviedatabase.data.model.tvshow.TvShowModel

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShowModel>? = tvShowRepository.getTvShow()
}