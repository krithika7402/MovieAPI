package com.example.movieapi.domain.item

import com.example.movieapi.data.models.MovieModel

data class MovieItem(
    val imdbID: String,
    val Title: String,
    val Poster: String,
    val Year: String,
)

fun MovieModel.toMovieItem() = MovieItem(imdbID, Title, Poster, Year)