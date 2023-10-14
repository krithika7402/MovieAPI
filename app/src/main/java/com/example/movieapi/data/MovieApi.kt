package com.example.movieapi.data

import com.example.movieapi.data.models.MovieSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("/")
    suspend fun getMovies(
        @Query("s") searchQuery: String,
        @Query("apikey") apiKey: String
    ): Response<MovieSearchResponse>
}
