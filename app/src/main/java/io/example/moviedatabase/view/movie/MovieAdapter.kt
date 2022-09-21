package io.example.moviedatabase.view.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.example.moviedatabase.R
import io.example.moviedatabase.data.model.movie.MovieModel
import io.example.moviedatabase.databinding.ListItemBinding

class MovieAdapter: RecyclerView.Adapter<MyViewHolder>() {

    private var movieList = arrayListOf<MovieModel>()

    fun updateList(list: List<MovieModel>) {
        movieList.clear()
        this.movieList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

}

class MyViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun binding(movie: MovieModel) {
        binding.itemTitle.text = movie.title
        val url = "https://image.tmdb.org/t/p/w500/" + movie.poster_path
        Glide.with(binding.itemImage.context)
            .load(url)
            .into(binding.itemImage)
    }

}