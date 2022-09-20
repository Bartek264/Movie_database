package io.example.moviedatabase.di.core

import dagger.Component
import io.example.moviedatabase.di.database.CacheDataModule
import io.example.moviedatabase.di.database.DatabaseModule
import io.example.moviedatabase.di.database.LocalDataModule
import io.example.moviedatabase.di.database.RemoteDataModule
import io.example.moviedatabase.di.scope.movie.MovieSubComponent
import io.example.moviedatabase.di.scope.people.PeopleSubComponent
import io.example.moviedatabase.di.scope.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        CacheDataModule::class,
        DatabaseModule::class,
        LocalDataModule::class,
        RemoteDataModule::class]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun peopleSubComponent(): PeopleSubComponent.Factory

}