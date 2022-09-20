package io.example.moviedatabase.di.scope.tvshow

import dagger.Module
import dagger.Provides
import io.example.moviedatabase.data.domain.usecase.tvshow.GetTvShowUseCase
import io.example.moviedatabase.data.domain.usecase.tvshow.UpdateTvShowUseCase
import io.example.moviedatabase.viewmodel.TvShowViewModelFactory

@Module
class TvShowModule {

    @Provides
    fun provideTvShowViewModel(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory = TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)

}