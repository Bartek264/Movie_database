package io.example.moviedatabase.view.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.example.moviedatabase.R
import io.example.moviedatabase.databinding.ActivityMovieBinding
import io.example.moviedatabase.di.Injector
import io.example.moviedatabase.viewmodel.MovieViewModel
import io.example.moviedatabase.viewmodel.MovieViewModelFactory
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieViewModelFactory

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding

    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        movieAdapter = MovieAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        val responseData = movieViewModel.getMovies()
        binding.progressBar.visibility = View.VISIBLE
        responseData.observe(this) {
            movieAdapter.updateList(it!!)
            binding.progressBar.visibility = View.GONE
        }
    }
}