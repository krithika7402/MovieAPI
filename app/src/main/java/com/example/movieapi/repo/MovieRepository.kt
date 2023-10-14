package com.example.movieapi.repo

import com.example.movieapi.data.MovieService
import com.example.movieapi.domain.item.MovieItem
import com.example.movieapi.domain.item.toMovieItem
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieService: MovieService) {
    suspend fun getMovies(searchQuery: String) : List<MovieItem>{
        return movieService.getMovies(searchQuery).map {
            it.toMovieItem()
        }
    }
}
