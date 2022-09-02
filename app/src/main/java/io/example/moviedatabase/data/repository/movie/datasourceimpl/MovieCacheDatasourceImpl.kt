package io.example.moviedatabase.data.repository.movie.datasourceimpl

import io.example.moviedatabase.data.model.movie.MovieModel
import io.example.moviedatabase.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDatasourceImpl: MovieCacheDatasource {
    private var movieList = ArrayList<MovieModel>()

    override suspend fun getMoviesFromCache(): List<MovieModel> = movieList

    override suspend fun saveMoviesToCache(model: List<MovieModel>) {
        movieList.clear()
        movieList = ArrayList(model)

    }
}