package com.mustk.movieappcompose.domain.usecase.get_movie_detail

import coil.network.HttpException
import com.mustk.movieappcompose.data.remote.mapper.toMovieDetail
import com.mustk.movieappcompose.domain.model.MovieDetail
import com.mustk.movieappcompose.domain.repository.MovieRepository
import com.mustk.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetail(imdbId: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId)
            if (movieDetail.Response == "True") {
                emit(Resource.Success(movieDetail.toMovieDetail()))
            } else {
                emit(Resource.Error(message = "No movie found!"))
            }
        } catch (e: IOError) {
            emit(Resource.Error("No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}