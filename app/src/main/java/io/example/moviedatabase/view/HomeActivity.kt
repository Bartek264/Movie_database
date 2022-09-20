package io.example.moviedatabase.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import io.example.moviedatabase.R
import io.example.moviedatabase.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.movieButton.setOnClickListener { startActivity(Intent(this, MovieActivity::class.java)) }
        binding.peopleButton.setOnClickListener { startActivity(Intent(this, PeopleActivity::class.java)) }
        binding.tvshowButton.setOnClickListener { startActivity(Intent(this, TvShowActivity::class.java)) }

    }
}