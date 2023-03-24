package com.example.week2.service

import com.example.week2.model.MovieResp
import com.example.week2.singleonData.MovieID
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApis {
    @GET("movie/now_playing")
    suspend fun listNowPlayMovies(
        @Query("language") language: String, @Query("page") page: Int
    ): MovieResp

    //    ///movie/upcoming
    @GET("movie/top_rated")
    suspend fun listTopRatedMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieResp
    @GET("movie/{movie_id}")
    suspend fun singleMovie(
        @Path("movie_id") id: Long, @Query("language") language: String
    ): MovieID
}
