package com.example.week2.bottomNavigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week2.databinding.MovieItemBinding
import com.example.week2.model.Movie

class MovieAdapter() : ListAdapter<Movie, MovieAdapter.MovieVH>(MovieDiffUtilCallback()) {
    var onItemClick: ((Movie) -> Unit)? = null

    class MovieDiffUtilCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }


    class MovieVH private constructor(var binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var currentRestaurantData: Movie



        companion object {
            fun from(parent: ViewGroup): MovieVH {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieItemBinding.inflate(layoutInflater, parent, false)
                return MovieVH(binding)
            }
        }

        fun binding(item: Movie) {
            currentRestaurantData = item

            binding.restaurantName.text = item.title?.trim()
            binding.restaurantAddress.text = item.overview?.trim()
            val urlImage = "https://image.tmdb.org/t/p/w500${item.posterPath}"
            Glide.with(itemView.context).load(urlImage)
                .into(binding.restaurantAvt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        return MovieVH.from(parent)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val movie = getItem(position)
        holder.binding(movie)

    }




}
