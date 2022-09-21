package io.example.moviedatabase.di.scope.people

import dagger.Subcomponent
import io.example.moviedatabase.view.people.PeopleActivity

@PeopleScope
@Subcomponent(modules = [PeopleModule::class])
interface PeopleSubComponent {
    fun inject(peopleActivity: PeopleActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): PeopleSubComponent
    }
}