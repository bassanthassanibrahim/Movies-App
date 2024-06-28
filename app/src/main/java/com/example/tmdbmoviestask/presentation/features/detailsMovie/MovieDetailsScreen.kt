package com.example.tmdbmoviestask.presentation.features.detailsMovie

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.tmdbmoviestask.presentation.features.homeScreen.MoviesViewModel

@Composable
fun DetailsMovieScreen(
    viewModel: MoviesViewModel,
) {

    val selectedMovie by viewModel.selectedMovieDetailsState.collectAsState()


    selectedMovie?.let {
        MovieDetailsItem(movie = it)
    }

}

