package io.example.moviedatabase.view

import android.app.Application
import io.example.moviedatabase.BuildConfig
import io.example.moviedatabase.di.Injector
import io.example.moviedatabase.di.core.AppComponent
import io.example.moviedatabase.di.core.AppModule
import io.example.moviedatabase.di.core.DaggerAppComponent
import io.example.moviedatabase.di.core.NetModule
import io.example.moviedatabase.di.database.RemoteDataModule
import io.example.moviedatabase.di.scope.movie.MovieSubComponent
import io.example.moviedatabase.di.scope.people.PeopleSubComponent
import io.example.moviedatabase.di.scope.tvshow.TvShowSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent = appComponent.movieSubComponent().create()

    override fun createTvShowSubComponent(): TvShowSubComponent = appComponent.tvShowSubComponent().create()

    override fun createPeopleSubComponent(): PeopleSubComponent = appComponent.peopleSubComponent().create()


}