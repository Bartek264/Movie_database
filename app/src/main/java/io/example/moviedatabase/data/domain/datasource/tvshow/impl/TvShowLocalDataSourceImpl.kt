package io.example.moviedatabase.data.domain.datasource.tvshow.impl

import io.example.moviedatabase.data.dao.tvshow.TvShowDao
import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowLocalDataSource
import io.example.moviedatabase.data.model.tvshow.TvShowModel

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShow(): List<TvShowModel>? = tvShowDao.getTvShow()

    override suspend fun saveTvShow(tvShowModel: List<TvShowModel>) = tvShowDao.saveTvShow(tvShowModel)

    override suspend fun clearAll() = tvShowDao.deleteAll()
}