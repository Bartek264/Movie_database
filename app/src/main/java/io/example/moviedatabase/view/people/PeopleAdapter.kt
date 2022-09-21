package io.example.moviedatabase.view.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.example.moviedatabase.R
import io.example.moviedatabase.data.model.movie.MovieModel
import io.example.moviedatabase.data.model.people.PeopleModel
import io.example.moviedatabase.databinding.ListItemBinding

class PeopleAdapter: RecyclerView.Adapter<MyViewHolder>() {

    private var peopleList = arrayListOf<PeopleModel>()

    fun updateList(list: List<PeopleModel>) {
        peopleList.clear()
        this.peopleList.addAll(list)
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
        holder.binding(peopleList[position])
    }

    override fun getItemCount(): Int = peopleList.size

}

class MyViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun binding(people: PeopleModel) {
        binding.itemTitle.text = people.name
        val url = "https://image.tmdb.org/t/p/w500/" + people.profile_path
        Glide.with(binding.itemImage.context)
            .load(url)
            .into(binding.itemImage)
    }

}