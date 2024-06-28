package com.example.tmdbmoviestask.domain

import androidx.paging.PagingData
import com.example.tmdbmoviestask.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepo {

    fun getPopularMoviesPagingFlow(): Flow<PagingData<Movie>>

    suspend fun getMovieDetailsById(id:Int): Movie?

}