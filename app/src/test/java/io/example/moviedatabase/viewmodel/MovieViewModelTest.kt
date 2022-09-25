package io.example.moviedatabase.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.example.moviedatabase.data.domain.usecase.movie.GetMovieUseCase
import io.example.moviedatabase.data.domain.usecase.movie.UpdateMovieUseCase
import io.example.moviedatabase.data.model.movie.MovieModel
import io.example.moviedatabase.getOrAwaitValue
import io.example.moviedatabase.viewmodel.repository.FakeMovieRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    // Zapewnia odpalnie testu w sposób synchroniczny
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    // Fake movie repository
    @Before
    fun setUp() {
        // Konstruktory MovieUseCase są dziedziczone z MovieRepository dlatego musimy stworzyć wesje fake
        val fakeMovieRepository = FakeMovieRepository()
        val getMovieUseCase = GetMovieUseCase(fakeMovieRepository)
        val updateMovieUseCase = UpdateMovieUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMovieUseCase, updateMovieUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList() {
        val movies = ArrayList<MovieModel>()
        movies.add(MovieModel(1, false, "back_path", "en", "org_title", "test", 5.0, "path", "15.02.2011", "title", true, 3.7, 3))
        movies.add(MovieModel(2, true, "back_path", "en", "org_title", "test2", 8.2, "path", "18.02.2011", "title", true, 4.7, 3))
        movies.add(MovieModel(3, false, "back_path", "en", "org_title", "test3", 3.2, "path", "11.02.2011", "title", true, 5.7, 3))

        /** Pobieramy liste z liveData i za pomocą LiveDataTestUtil zamieniamy ją w liste
         * @see getOrAwaitValue
         */
        val currentMovieList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentMovieList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsUpdatedList() {
        val movies = ArrayList<MovieModel>()
        movies.add(MovieModel(4, false, "back_path1", "en", "org_title", "test", 5.0, "path", "15.02.2011", "title", true, 3.7, 3))
        movies.add(MovieModel(5, true, "back_path2", "en", "org_title", "test2", 8.2, "path", "18.02.2011", "title", true, 4.7, 3))
        movies.add(MovieModel(6, false, "back_path3", "en", "org_title", "test3", 3.2, "path", "11.02.2011", "title", true, 5.7, 3))

        /** Pobieramy liste z liveData i za pomocą LiveDataTestUtil zamieniamy ją w liste
         * @see getOrAwaitValue
         */
        val updatedMovieList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedMovieList).isEqualTo(movies)
    }

}
