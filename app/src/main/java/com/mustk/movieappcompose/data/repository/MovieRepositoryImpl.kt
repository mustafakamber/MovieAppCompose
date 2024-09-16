package com.mustk.movieappcompose.data.repository

import com.mustk.movieappcompose.data.remote.MovieAPI
import com.mustk.movieappcompose.data.remote.dto.MovieDetailDTO
import com.mustk.movieappcompose.data.remote.dto.MovieListDTO
import com.mustk.movieappcompose.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MovieListDTO {
        return api.getMovieList(search = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDTO {
        return api.getMovieDetail(imdbId = imdbId)
    }
}