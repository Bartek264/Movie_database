package io.example.moviedatabase.data.api

import io.example.moviedatabase.data.model.MovieModelList
import io.example.moviedatabase.data.model.PeopleModelList
import io.example.moviedatabase.data.model.TvShowModelList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieModelList>

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key") apiKey: String): Response<TvShowModelList>

    @GET("person/popular")
    suspend fun getPopularPeople(@Query("api_key") apiKey: String): Response<PeopleModelList>
}