package io.example.moviedatabase.data.repository.movie.datasourceimpl

import io.example.moviedatabase.data.api.TMDBService
import io.example.moviedatabase.data.model.movie.MovieModelList
import io.example.moviedatabase.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(private val tmdbService: TMDBService,
                                private val apiKey: String): MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieModelList> = tmdbService.getPopularMovies(apiKey)
}