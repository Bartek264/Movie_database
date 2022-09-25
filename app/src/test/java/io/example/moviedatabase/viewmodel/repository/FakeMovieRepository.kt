package io.example.moviedatabase.viewmodel.repository

import io.example.moviedatabase.data.domain.usecase.movie.MovieRepository
import io.example.moviedatabase.data.model.movie.MovieModel
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FakeMovieRepository: MovieRepository {

    private var movies = ArrayList<MovieModel>()

    init {
        movies.add(MovieModel(1, false, "back_path", "en", "org_title", "test", 5.0, "path", "15.02.2011", "title", true, 3.7, 3))
        movies.add(MovieModel(2, true, "back_path", "en", "org_title", "test2", 8.2, "path", "18.02.2011", "title", true, 4.7, 3))
        movies.add(MovieModel(3, false, "back_path", "en", "org_title", "test3",3.2, "path", "11.02.2011", "title", true, 5.7, 3))
    }

    override suspend fun getMovies(): List<MovieModel>? = movies

    override suspend fun updateMovies(): List<MovieModel>? {
        movies.clear()
        movies.add(MovieModel(4, false, "back_path1", "en", "org_title", "test", 5.0, "path", "15.02.2011", "title", true, 3.7, 3))
        movies.add(MovieModel(5, true, "back_path2", "en", "org_title", "test2", 8.2, "path", "18.02.2011", "title", true, 4.7, 3))
        movies.add(MovieModel(6, false, "back_path3", "en", "org_title", "test3", 3.2, "path", "11.02.2011", "title", true, 5.7, 3))
        return movies
    }
}