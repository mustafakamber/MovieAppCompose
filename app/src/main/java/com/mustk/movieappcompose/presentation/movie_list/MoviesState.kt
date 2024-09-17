package com.mustk.movieappcompose.presentation.movie_list

import com.mustk.movieappcompose.domain.model.Movie

data class MoviesState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = "",
    val search: String = "batman"
)