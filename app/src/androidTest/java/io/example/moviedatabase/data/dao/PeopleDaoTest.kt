package io.example.moviedatabase.data.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import io.example.moviedatabase.data.dao.people.PeopleDao
import io.example.moviedatabase.data.model.people.PeopleModel
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PeopleDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val peopleList = arrayListOf(
        PeopleModel(1, false, 1, "en", "en", 2.1, "path"),
        PeopleModel(2, false, 3, "en", "en", 3.1, "path"),
        PeopleModel(3, false, 2, "en", "en", 4.1, "path"))

    private lateinit var peopleDao: PeopleDao
    private lateinit var tmdbDatabase: TMDBDatabase

    @Before
    fun setUp() {
        tmdbDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), TMDBDatabase::class.java).build()
        peopleDao = tmdbDatabase.peopleDao()
    }

    @After
    fun tearDown() {
        tmdbDatabase.close()
    }

    @Test
    fun savePeople(): Unit = runBlocking {
        peopleDao.savePeople(peopleList)
        val response = peopleDao.getPeople()
        Truth.assertThat(response).isEqualTo(peopleList)
    }

    @Test
    fun deleteAllPeople(): Unit = runBlocking {
        peopleDao.savePeople(peopleList)
        peopleDao.deleteAll()
        val response = peopleDao.getPeople()
        Truth.assertThat(response).isEmpty()
    }

}