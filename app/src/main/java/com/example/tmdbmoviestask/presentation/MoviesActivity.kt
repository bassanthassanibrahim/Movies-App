package com.example.tmdbmoviestask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import coil.Coil
import coil.ImageLoader
import coil.request.CachePolicy
import com.example.tmdbmoviestask.theme.TMDbMoviesTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imageLoader = ImageLoader.Builder(this)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .build()

        Coil.setImageLoader(imageLoader) // S

        setContent {
            TMDbMoviesTaskTheme {
                TMDApp()
            }
        }
    }
}
