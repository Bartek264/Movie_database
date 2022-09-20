package io.example.moviedatabase.data.domain.datasource.tvshow.impl

import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowCacheDataSource
import io.example.moviedatabase.data.model.tvshow.TvShowModel

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShowModel>()

    override suspend fun getTvShowFromDB(): List<TvShowModel> = tvShowList

    override suspend fun saveTvShowToDB(tvShowModel: List<TvShowModel>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShowModel)
    }
}