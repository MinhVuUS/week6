package com.example.week2.restaurant

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week2.singleonData.DataStore
import com.example.week2.R
import com.example.week2.databinding.MovieItemBinding
import com.example.week2.model.Movie
import com.example.week2.singleonData.Restaurant

//class ResViewHolder(private var binding: MovieItemBinding, private val setList: (MutableList<Restaurant>)-> Unit): RecyclerView.ViewHolder(binding.root) {
//    private lateinit var currenRestaurantData: Restaurant
//    init {
//        binding.root.setOnClickListener{ showDialog(currenRestaurantData) }
//    }
//    fun bindData(restaurant: Movie, callback: OnHomeItemClick) {
//        currenRestaurantData = restaurant
//        binding.restaurantData = restaurant
//        Glide.with(binding.root.context).load(restaurant.avatar).centerCrop().into(binding.restaurantAvt)
//    }
//
//
//    private fun showDialog(restaurant: Restaurant) {
//
//        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(binding.root.context)
//        alertDialog.setTitle("Confirm")
//        alertDialog.setIcon(R.mipmap.ic_launcher)
//        alertDialog.setMessage("Do you want to delete this restaurant?")
//
//        alertDialog.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
//            val newList: MutableList<Restaurant> = mutableListOf()
//            DataStore.restaurantData.value?.let { newList.addAll(it) }
//            newList.remove(restaurant)
//            setList(newList)
//        }
//        alertDialog.setNegativeButton("No"){ _: DialogInterface, _: Int ->
//
//        }
//
//        alertDialog.show()
//    }
//
//
//
//    companion object {
//        fun from(parent: ViewGroup, setList: (MutableList<Restaurant>) -> Unit): ResViewHolder {
//            val binding: MovieItemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//            return ResViewHolder(binding) { setList(it) }
//        }
//    }

//}
class ResViewHolder(private val binding: MovieItemBinding ): RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentRestaurantData: Movie
    private lateinit var callback: OnHomeItemClick
    init {
        binding.root.setOnClickListener{ callback.onClickItem(binding.root, currentRestaurantData) }
        binding.root.setOnLongClickListener {
            callback.onLongClick(binding.root)
            true
        }
    }

    fun bindData(movie: Movie, callback: OnHomeItemClick) {
        currentRestaurantData = movie
        this.callback = callback
        binding.movieData = movie
        val urlImage = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
        Glide.with(binding.root.context).load(urlImage).into(binding.restaurantAvt)
    }

    companion object {
        fun from(parent: ViewGroup): ResViewHolder {
            val binding: MovieItemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ResViewHolder(binding)
        }

    }
}