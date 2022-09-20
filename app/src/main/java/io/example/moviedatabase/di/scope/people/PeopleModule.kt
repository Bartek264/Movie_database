package io.example.moviedatabase.di.scope.people

import dagger.Module
import dagger.Provides
import io.example.moviedatabase.data.domain.usecase.people.GetPeopleUseCase
import io.example.moviedatabase.data.domain.usecase.people.UpdatePeopleUseCase
import io.example.moviedatabase.viewmodel.PeopleViewModelFactory

@Module
class PeopleModule {

    @Provides
    @PeopleScope
    fun providePeopleViewModelFactory(
        getPeopleUseCase: GetPeopleUseCase,
        updatePeopleUseCase: UpdatePeopleUseCase
    ):PeopleViewModelFactory = PeopleViewModelFactory(getPeopleUseCase, updatePeopleUseCase)

}