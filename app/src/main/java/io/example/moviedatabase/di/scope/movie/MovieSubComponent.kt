package io.example.moviedatabase.di.scope.movie

import dagger.Subcomponent
import io.example.moviedatabase.view.MovieActivity

@MovieScope
@Subcomponent(modules = [MovieModel::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}