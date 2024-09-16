package com.mustk.movieappcompose.domain.repository

import com.mustk.movieappcompose.data.remote.dto.MovieDetailDTO
import com.mustk.movieappcompose.data.remote.dto.MovieListDTO

interface MovieRepository {

    suspend fun getMovies(search: String): MovieListDTO

    suspend fun getMovieDetail(imdbId: String): MovieDetailDTO
}