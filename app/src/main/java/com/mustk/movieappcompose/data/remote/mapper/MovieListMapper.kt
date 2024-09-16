package com.mustk.movieappcompose.data.remote.mapper

import com.mustk.movieappcompose.data.remote.dto.MovieListDTO
import com.mustk.movieappcompose.domain.model.Movie

fun MovieListDTO.toMovieList(): List<Movie> {
    return Search.map { search ->
        Movie(search.Poster, search.Title, search.Year, search.imdbID)
    }
}