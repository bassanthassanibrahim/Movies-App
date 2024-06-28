package com.example.tmdbmoviestask.data

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.example.tmdbmoviestask.data.local.dao.MovieDao
import com.example.tmdbmoviestask.data.local.model.MovieEntity
import com.example.tmdbmoviestask.data.mapper.toMovie
import com.example.tmdbmoviestask.data.mapper.toMovieOrNull
import com.example.tmdbmoviestask.domain.MovieRepo
import com.example.tmdbmoviestask.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val pager:Pager<Int , MovieEntity>
) : MovieRepo {

    override fun getPopularMoviesPagingFlow(): Flow<PagingData<Movie>> {
       return pager.flow.map {pagingData -> pagingData.map { it.toMovie() } }
    }


    override suspend fun getMovieDetailsById(id: Int): Movie? {
       return movieDao.getMovieDetailsById(id).toMovieOrNull()
    }


}