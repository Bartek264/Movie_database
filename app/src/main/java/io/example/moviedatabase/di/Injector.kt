package io.example.moviedatabase.di

import io.example.moviedatabase.di.scope.movie.MovieSubComponent
import io.example.moviedatabase.di.scope.people.PeopleSubComponent
import io.example.moviedatabase.di.scope.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createPeopleSubComponent(): PeopleSubComponent

}