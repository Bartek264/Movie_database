package io.example.moviedatabase.data.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.example.moviedatabase.data.dao.tvshow.TvShowDao
import io.example.moviedatabase.data.model.tvshow.TvShowModel
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TvShowDaoList {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val tvShowList = arrayListOf(
        TvShowModel(1, "path", "air", "name", "en", "en", "over", 1.1, "path", 1.1, 752),
        TvShowModel(2, "path", "air", "name", "en", "en", "over", 1.1, "path", 1.1, 752),
        TvShowModel(3, "path", "air", "name", "en", "en", "over", 1.1, "path", 1.1, 752),
    )

    private lateinit var tmdbDatabase: TMDBDatabase
    private lateinit var tvShowDao: TvShowDao

    @Before
    fun setUp() {
        tmdbDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), TMDBDatabase::class.java).build()
        tvShowDao = tmdbDatabase.tvShowDao()
    }

    @After
    fun tearDown() {
        tmdbDatabase.close()
    }

    @Test
    fun saveTvShow(): Unit = runBlocking {
        tvShowDao.saveTvShow(tvShowList)
        val result = tvShowDao.getTvShow()
        assertThat(result).isEqualTo(tvShowList)
    }

    @Test
    fun deleteTvShow(): Unit = runBlocking {
        tvShowDao.saveTvShow(tvShowList)
        tvShowDao.deleteAll()
        val result = tvShowDao.getTvShow()
        assertThat(result).isEmpty()
    }
}