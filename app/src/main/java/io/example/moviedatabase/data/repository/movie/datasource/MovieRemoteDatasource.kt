package io.example.moviedatabase.data.repository.movie.datasource

import io.example.moviedatabase.data.model.movie.MovieModelList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieModelList>
}