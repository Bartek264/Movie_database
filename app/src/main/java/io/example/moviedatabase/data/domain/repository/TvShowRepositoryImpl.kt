package io.example.moviedatabase.data.domain.repository

import android.util.Log
import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowCacheDataSource
import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowLocalDataSource
import io.example.moviedatabase.data.domain.datasource.tvshow.TvShowRemoteDataSource
import io.example.moviedatabase.data.domain.usecase.tvshow.TvShowRepository
import io.example.moviedatabase.data.model.tvshow.TvShowModel

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {
    override suspend fun getTvShow(): List<TvShowModel> = getTvShowFromCache()

    override suspend fun updateTvShow(): List<TvShowModel> {
        val newTvShowList = getTvShowFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShow(newTvShowList)
        tvShowCacheDataSource.saveTvShowToDB(newTvShowList)
        return newTvShowList
    }

    suspend fun getTvShowFromApi(): List<TvShowModel> {
        var tvShowList = listOf<TvShowModel>()

        try {
            val response = tvShowRemoteDataSource.getTvShow()
            val body = response.body()

            if (body != null) {
                tvShowList = body.results!!
            }

        } catch (e: Exception) {
            Log.v(this::class.simpleName, "getTvShowFromApi ERROR: ${e.message}")
        }

        return tvShowList
    }

    suspend fun getTvShowFromLocal(): List<TvShowModel> {
        var tvShowList = listOf<TvShowModel>()

        try {
            val response = tvShowLocalDataSource.getTvShow()

            if (response != null) {
                tvShowList = response
            }

        } catch (e: Exception) {
            Log.v(this::class.simpleName, "getTvShowFromLocal ERROR: ${e.message}")
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromApi()
            tvShowLocalDataSource.saveTvShow(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShowModel> {
        var tvShowList = listOf<TvShowModel>()

        try {
            val response = tvShowLocalDataSource.getTvShow()

            if (response != null) {
                tvShowList = response
            }

        } catch (e: Exception) {
            Log.v(this::class.simpleName, "getTvShowFromLocal ERROR: ${e.message}")
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromLocal()
            tvShowCacheDataSource.saveTvShowToDB(tvShowList)
        }

        return tvShowList
    }

}