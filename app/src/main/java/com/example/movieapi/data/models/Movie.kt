package com.example.movieapi.data.models

data class MovieModel(
    val imdbID: String,
    val Title: String,
    val Poster: String,
    val Year: String
)

data class MovieSearchResponse(
    val Search: List<MovieModel>,
    val totalResults: String,
    val Response: String
)
