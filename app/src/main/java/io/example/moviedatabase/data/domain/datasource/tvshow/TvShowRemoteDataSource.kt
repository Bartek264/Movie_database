package io.example.moviedatabase.data.domain.datasource.tvshow

import io.example.moviedatabase.data.dao.tvshow.TvShowDao
import io.example.moviedatabase.data.model.tvshow.TvShowModelList
import retrofit2.Response

interface TvShowRemoteDataSource {
    /**
     * Zwrotka z
     * @see TvShowDao.getTvShow
     */
    suspend fun getTvShow(): Response<TvShowModelList>
}