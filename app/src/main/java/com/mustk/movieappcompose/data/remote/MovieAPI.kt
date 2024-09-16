package com.mustk.movieappcompose.data.remote

import com.mustk.movieappcompose.data.remote.dto.MovieDetailDTO
import com.mustk.movieappcompose.data.remote.dto.MovieListDTO
import com.mustk.movieappcompose.util.Constant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET(".")
    suspend fun getMovieList(
        @Query("s") search : String,
        @Query("apikey") apikey : String = API_KEY
    ) : MovieListDTO

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apikey : String = API_KEY
    ) : MovieDetailDTO
}