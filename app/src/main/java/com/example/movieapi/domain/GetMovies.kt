package com.example.movieapi.domain

import com.example.movieapi.domain.item.MovieItem
import com.example.movieapi.repo.MovieRepository
import javax.inject.Inject

class GetMoviesCall @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(searchQuery: String): List<MovieItem> {
        return movieRepository.getMovies(searchQuery).shuffled()
    }
}
