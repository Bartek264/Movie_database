package io.example.moviedatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.example.moviedatabase.data.domain.usecase.people.GetPeopleUseCase
import io.example.moviedatabase.data.domain.usecase.people.UpdatePeopleUseCase
import io.example.moviedatabase.data.domain.usecase.tvshow.GetTvShowUseCase
import io.example.moviedatabase.data.domain.usecase.tvshow.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModel() {

    fun getTvShow() = liveData {
        val list = getTvShowUseCase.execute()
        emit(list)
    }

    fun updateTvShow() = liveData {
        val list = updateTvShowUseCase.execute()
        emit(list)
    }

}