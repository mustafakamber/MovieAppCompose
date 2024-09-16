package com.mustk.movieappcompose.data.remote.dto

data class MovieListDTO(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)