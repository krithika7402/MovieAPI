package com.example.movieapi.data

import com.example.movieapi.data.models.MovieModel
import com.example.movieapi.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val movieApi: MovieApi){
    suspend fun getMovies(searchQuery: String) : List<MovieModel> {
        return withContext(Dispatchers.IO){
            val response = movieApi.getMovies(searchQuery, apiKey = Constants.API_KEY)
            if(response.isSuccessful) {
                val movieSearchResponse = response.body()
                movieSearchResponse?.Search ?: emptyList()
            } else {
                emptyList()
            }
        }
    }
}
