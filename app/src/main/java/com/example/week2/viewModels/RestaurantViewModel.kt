package com.example.week2.viewModels

import android.app.Activity
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week2.R
import com.example.week2.model.Movie
import com.example.week2.service.MovieRestClient
import com.example.week2.singleonData.DataStore
import kotlinx.coroutines.launch

class RestaurantViewModel: ViewModel() {
    private val _newList: MutableLiveData<MutableList<Movie>> = MutableLiveData()
    val newList: LiveData<MutableList<Movie>>
        get() = _newList
    private val _tabID: MutableLiveData<Int> = MutableLiveData(R.id.nplaying)
    val tabID: LiveData<Int>
        get() = _tabID

    private val _menuLayoutType: MutableLiveData<Int> = MutableLiveData(R.id.menu_linear)
    val menuLayoutType: LiveData<Int>
        get() = _menuLayoutType

//    fun getLayout(restaurantActivity: Activity): RecyclerView.LayoutManager {
//        return when (_menuLayoutType.value) {
//            R.id.menu_linear -> LinearLayoutManager(restaurantActivity)
//            else -> {
//                GridLayoutManager(restaurantActivity, 2)
//            }
//        }
//    }
    fun getLayout(restaurantActivity: Activity): RecyclerView.LayoutManager {
        return when (_menuLayoutType.value) {
            R.id.menu_linear -> LinearLayoutManager(restaurantActivity)
            else -> {GridLayoutManager(restaurantActivity, 2)}
        }
    }

    fun setLayout(itemId: Int) {
        _menuLayoutType.postValue(itemId)
    }
    private fun getNowPlayingMovie() {
        viewModelScope.launch {
            val movieResp = MovieRestClient.getInstance().api.listNowPlayMovies(language = "en-US", page = 1)
            _newList.postValue(movieResp.results?.toMutableList()  )
        }
    }
    private fun getTopRatedMovie() {
        viewModelScope.launch {
            val movieResp = MovieRestClient.getInstance().api.listTopRatedMovies(language = "en-US", page = 1)
            _newList.postValue(movieResp.results?.toMutableList() )
        }
    }

    fun handleItemWhenClicked(item: View, movie: Movie, controller: NavController) {
        viewModelScope.launch {
            DataStore.curMovieData.postValue(movie.id?.let { MovieRestClient.getInstance().api.singleMovie(language = "en-US", id = it) })
            controller.navigate(R.id.action_restaurantFragment_to_movieFragment)
        }

    }
    fun handleItemWhenLongClicked(item: View) {
        /// TODO
    }
    fun setTabID(itemId: Int) {
        _tabID.postValue(itemId)
    }
    fun getMovies() {
        when(_tabID.value){
            R.id.nplaying -> getNowPlayingMovie()
            else -> getTopRatedMovie()
        }
    }

}