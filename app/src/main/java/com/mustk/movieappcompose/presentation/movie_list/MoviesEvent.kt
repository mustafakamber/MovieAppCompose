package com.mustk.movieappcompose.presentation.movie_list

sealed class MoviesEvent {
    data class Search(val searchString : String) : MoviesEvent()
}