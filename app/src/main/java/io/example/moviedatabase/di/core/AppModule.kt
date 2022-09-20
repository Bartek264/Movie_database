package io.example.moviedatabase.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import io.example.moviedatabase.di.scope.movie.MovieSubComponent
import io.example.moviedatabase.di.scope.people.PeopleSubComponent
import io.example.moviedatabase.di.scope.tvshow.TvShowSubComponent
import javax.inject.Singleton

/**
 * Zapewnia Context dla Daggera
 */

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, PeopleSubComponent::class])
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = context.applicationContext

}