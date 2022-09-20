package io.example.moviedatabase.data.domain.datasource.movie.impl

import io.example.moviedatabase.data.domain.datasource.movie.MovieCacheDatasource
import io.example.moviedatabase.data.model.movie.MovieModel

class MovieCacheDatasourceImpl: MovieCacheDatasource {

    private var movieList = ArrayList<MovieModel>()

    override suspend fun getMoviesFromCache(): List<MovieModel> = movieList

    override suspend fun saveMoviesToCache(model: List<MovieModel>) {
        movieList.clear()
        movieList = ArrayList(model)
    }
}