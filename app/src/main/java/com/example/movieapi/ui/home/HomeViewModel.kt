package com.example.movieapi.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapi.domain.GetMoviesCall
import com.example.movieapi.domain.item.MovieItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMoviesCall: GetMoviesCall) : ViewModel() {
    private val _movies = MutableStateFlow(emptyList<MovieItem>())
    val movies: StateFlow<List<MovieItem>> get() = _movies

    fun getMovies(searchQuery: String) {
        viewModelScope.launch {
            try {
                val movies = getMoviesCall(searchQuery)
                _movies.value = movies
            }
            catch (_: Exception){

            }
        }
    }
}
