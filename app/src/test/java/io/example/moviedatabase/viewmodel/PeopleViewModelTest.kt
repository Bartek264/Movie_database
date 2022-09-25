package io.example.moviedatabase.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.example.moviedatabase.data.domain.usecase.people.GetPeopleUseCase
import io.example.moviedatabase.data.domain.usecase.people.UpdatePeopleUseCase
import io.example.moviedatabase.data.model.people.PeopleModel
import io.example.moviedatabase.getOrAwaitValue
import io.example.moviedatabase.viewmodel.repository.FakePeopleRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PeopleViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var peopleViewModel: PeopleViewModel

    @Before
    fun setUp() {
        val fakePeopleRepository = FakePeopleRepository()
        val getUseCase = GetPeopleUseCase(fakePeopleRepository)
        val updateGetUseCase = UpdatePeopleUseCase(fakePeopleRepository)
        peopleViewModel = PeopleViewModel(getUseCase, updateGetUseCase)
    }

    @Test
    fun getPeople_returnCurrentList() {
        val peopleList = ArrayList<PeopleModel>()
        peopleList.add(PeopleModel(1, false, 1, "en", "en", 2.1, "path"))
        peopleList.add(PeopleModel(2, false, 3, "en", "en", 3.1, "path"))
        peopleList.add(PeopleModel(3, false, 2, "en", "en", 4.1, "path"))
        val result = peopleViewModel.getPeople().getOrAwaitValue()
        assertThat(result).isEqualTo(peopleList)
    }

    @Test
    fun updatePeople_returnNewList() {
        val peopleList = ArrayList<PeopleModel>()
        peopleList.add(PeopleModel(4, false, 1, "en", "en", 5.1, "path"))
        peopleList.add(PeopleModel(5, false, 3, "en", "en", 6.1, "path"))
        peopleList.add(PeopleModel(6, false, 2, "en", "en", 7.1, "path"))
        val result = peopleViewModel.updatePeople().getOrAwaitValue()
        assertThat(result).isEqualTo(peopleList)
    }

}