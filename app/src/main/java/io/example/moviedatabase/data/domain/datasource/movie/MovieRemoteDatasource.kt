package io.example.moviedatabase.data.domain.datasource.movie

import io.example.moviedatabase.data.dao.movie.MovieDao
import io.example.moviedatabase.data.model.movie.MovieModelList
import retrofit2.Response

interface MovieRemoteDatasource {
    /**
     * @return zwraca to co pobiera z GET retrofitowego getMovies
     * @see MovieDao.getMovies
     */
    suspend fun getMovies(): Response<MovieModelList>
}