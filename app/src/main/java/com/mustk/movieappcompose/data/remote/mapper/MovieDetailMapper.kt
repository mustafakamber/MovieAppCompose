package com.mustk.movieappcompose.data.remote.mapper

import com.mustk.movieappcompose.data.remote.dto.MovieDetailDTO
import com.mustk.movieappcompose.domain.model.MovieDetail

fun MovieDetailDTO.toMovieDetail(): MovieDetail {
    return MovieDetail(Actors, Country, Director, Poster, Title, Year, imdbRating)
}