package com.example.week2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.week2.singleonData.DataStore
import com.example.week2.singleonData.MovieID

class MovieViewModel: ViewModel() {
    val curMovie: LiveData<MovieID>
        get() = DataStore.curMovieData
}