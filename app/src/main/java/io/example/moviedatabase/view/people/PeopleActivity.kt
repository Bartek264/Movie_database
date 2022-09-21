package io.example.moviedatabase.view.people

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.example.moviedatabase.R
import io.example.moviedatabase.databinding.ActivityPeopleBinding
import io.example.moviedatabase.di.Injector
import io.example.moviedatabase.view.movie.MovieAdapter
import io.example.moviedatabase.viewmodel.PeopleViewModel
import io.example.moviedatabase.viewmodel.PeopleViewModelFactory
import javax.inject.Inject

class PeopleActivity : AppCompatActivity() {
    @Inject
    lateinit var peopleViewModelFactory: PeopleViewModelFactory

    private lateinit var peopleViewModel: PeopleViewModel
    private lateinit var binding: ActivityPeopleBinding

    private lateinit var peopleAdapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_people)

        (application as Injector).createPeopleSubComponent().inject(this)
        peopleViewModel = ViewModelProvider(this, peopleViewModelFactory).get(PeopleViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        peopleAdapter = PeopleAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = peopleAdapter
        }
        displayPopularPeople()
    }

    private fun displayPopularPeople() {
        val responseData = peopleViewModel.getPeople()
        responseData.observe(this) { peopleList ->
            if (peopleList != null)
                peopleAdapter.updateList(peopleList)
            binding.progressBar.visibility = View.GONE
        }
    }

}