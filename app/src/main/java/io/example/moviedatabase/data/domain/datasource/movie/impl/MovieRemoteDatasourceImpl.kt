package io.example.moviedatabase.data.domain.datasource.movie.impl

import io.example.moviedatabase.data.api.TMDBService
import io.example.moviedatabase.data.dao.movie.MovieDao
import io.example.moviedatabase.data.domain.datasource.movie.MovieRemoteDatasource
import io.example.moviedatabase.data.model.movie.MovieModelList
import retrofit2.Response

class MovieRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String):
    MovieRemoteDatasource {

    /**
     * @return response z GET na MovieDao
     * @see MovieDao.getMovies
     */
    override suspend fun getMovies(): Response<MovieModelList> = tmdbService.getPopularMovies(apiKey)

}