package com.mustk.movieappcompose.presentation

sealed class Screen(
    val route : String
) {
    data object MovieListScreen : Screen("movie_list_screen")
    data object MovieDetailScreen  : Screen("movie_detail_screen")
}