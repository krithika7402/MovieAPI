package com.example.movieapi.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.movieapi.domain.item.MovieItem
import com.example.movieapi.ui.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onSearch: (String) -> Unit,
    movies: List<MovieItem>
) {
    var searchText by remember { mutableStateOf("") } // State for the search text

    Column {
        // Search bar
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Search for movies") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Button(
            onClick = { onSearch(searchText) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Search")
        }

        LazyColumn {
            items(movies) { movie: MovieItem ->
                MovieCard(movie = movie)
            }
        }
    }
}



@Composable
fun MovieCard(movie: MovieItem) {

    val image = rememberImagePainter(data = movie.Poster)

    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()

    ) {

        Column {

            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(250.dp)
            )

            Column(modifier = Modifier.padding(10.dp)) {

                Text(text = movie.Title, fontWeight = FontWeight.Bold)
                Text(text = movie.Year, maxLines = 2, overflow = TextOverflow.Ellipsis)

            }

        }

    }

}