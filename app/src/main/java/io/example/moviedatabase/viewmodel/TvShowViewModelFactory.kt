package io.example.moviedatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.example.moviedatabase.data.domain.usecase.people.GetPeopleUseCase
import io.example.moviedatabase.data.domain.usecase.people.UpdatePeopleUseCase
import io.example.moviedatabase.data.domain.usecase.tvshow.GetTvShowUseCase
import io.example.moviedatabase.data.domain.usecase.tvshow.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}