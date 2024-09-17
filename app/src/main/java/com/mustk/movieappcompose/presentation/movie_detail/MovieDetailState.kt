package com.mustk.movieappcompose.presentation.movie_detail

import com.mustk.movieappcompose.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error: String = "",
    val search: String = ""
)