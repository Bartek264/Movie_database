package io.example.moviedatabase.data.domain.datasource.tvshow.impl

import io.example.moviedatabase.data.api.TMDBService
import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowRemoteDataSource
import io.example.moviedatabase.data.model.tvshow.TvShowModelList
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey: String): TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvShowModelList> = tmdbService.getPopularTvShow(apiKey)
}