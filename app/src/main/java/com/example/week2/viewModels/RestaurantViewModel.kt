package com.example.week2.viewModels

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week2.R

class RestaurantViewModel: ViewModel() {

    private val _menuLayoutType: MutableLiveData<Int> = MutableLiveData(R.id.menu_linear)
    val menuLayoutType: LiveData<Int>
        get() = _menuLayoutType

    fun getLayout(restaurantActivity: Activity): RecyclerView.LayoutManager {
        return when (_menuLayoutType.value) {
            R.id.menu_linear -> LinearLayoutManager(restaurantActivity)
            else -> {
                GridLayoutManager(restaurantActivity, 2)
            }
        }
    }

    fun setLayout(itemId: Int) {
        _menuLayoutType.postValue(itemId)
    }
}