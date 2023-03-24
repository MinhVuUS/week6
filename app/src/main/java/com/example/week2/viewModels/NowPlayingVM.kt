package com.example.week2.viewModels

import android.app.Activity
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week2.R

import com.example.week2.model.Movie
import com.example.week2.service.MovieRestClient
import com.example.week2.singleonData.DataStore
import kotlinx.coroutines.launch

class NowPlayingVM: ViewModel() {
    private var _movieData: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    val movieData: LiveData<List<Movie>>
        get() = _movieData
    private val _menuLayoutType: MutableLiveData<Int> = MutableLiveData(R.id.menu_linear)
    val menuLayoutType: LiveData<Int>
        get() = _menuLayoutType

    fun getNowPlaying() {
        viewModelScope.launch {
            val movieResp = MovieRestClient.getInstance().api.listNowPlayMovies(
                language = "en-US",
                page = 1,
            )
            _movieData.postValue(movieResp.results!!)
        }
    }
    fun setLayout(itemId: Int) {
        _menuLayoutType.postValue(itemId)
    }
    fun getLayout(restaurantActivity: Activity): RecyclerView.LayoutManager {
        return when (_menuLayoutType.value) {
            R.id.menu_linear -> LinearLayoutManager(restaurantActivity)
            else -> {
                GridLayoutManager(restaurantActivity, 2)
            }
        }
    }
}
//    fun handleItemWhenClicked(item: View, movie: Movie) {
//        viewModelScope.launch {
//            DataStore.curMovieData.postValue(movie.id?.let {
//                MovieRestClient.getInstance().api.singleMovie(
//                    language = "en-US",
//                    id = it
//                )
//            })
//
//        }
//    }
//    fun handleItemWhenLongClicked(item: View) {
//        /// TODO
//    }
//}
