package io.example.moviedatabase.data.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import io.example.moviedatabase.data.dao.movie.MovieDao
import io.example.moviedatabase.data.model.movie.MovieModel
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val moviesList = listOf(
        MovieModel(1, false, "back_path", "en", "org_title", "test", 5.0, "path", "15.02.2011", "title", true, 3.7, 3),
        MovieModel(2, true, "back_path", "en", "org_title", "test2", 8.2, "path", "18.02.2011", "title", true, 4.7, 3),
        MovieModel(3, false, "back_path", "en", "org_title", "test3", 3.2, "path", "11.02.2011", "title", true, 5.7, 3)
    )

    private lateinit var movieDao: MovieDao
    private lateinit var tmdbDatabase: TMDBDatabase

    // Tworzenie nowej bazy danych testowej w pamięci lokalnej telefonu
    @Before
    fun setUp() {
        tmdbDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), TMDBDatabase::class.java).build()
        movieDao = tmdbDatabase.movieDao()
    }

    // po zabiciu procesu baza jest kasowana
    @After
    fun tearDown() {
        tmdbDatabase.close()
    }

    /** Test funkcji
     * @see MovieDao.saveMovies
     */
    @Test
    fun saveMovies(): Unit = runBlocking {
        movieDao.saveMovies(moviesList)
        val allMovies = movieDao.getMovies()
        Truth.assertThat(allMovies).isEqualTo(moviesList)
    }

    /** Test funkcji
     * @see MovieDao.deleteAllMovies
     */
    @Test
    fun deleteMovies(): Unit = runBlocking {
        movieDao.saveMovies(moviesList)
        movieDao.deleteAllMovies()
        val result = movieDao.getMovies()
        Truth.assertThat(result).isEmpty()
    }
}