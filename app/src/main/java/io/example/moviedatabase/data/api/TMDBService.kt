package io.example.moviedatabase.data.api

import io.example.moviedatabase.data.model.movie.MovieModel
import io.example.moviedatabase.data.model.movie.MovieModelList
import io.example.moviedatabase.data.model.people.PeopleModelList
import io.example.moviedatabase.data.model.tvshow.TvShowModelList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieModelList>

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key") apiKey: String): Response<TvShowModelList>

    @GET("person/popular")
    suspend fun getPopularPeople(@Query("api_key") apiKey: String): Response<PeopleModelList>
}