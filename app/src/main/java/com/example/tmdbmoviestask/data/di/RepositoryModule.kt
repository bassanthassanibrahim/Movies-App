package com.example.tmdbmoviestask.data.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.RemoteMediator
import com.example.tmdbmoviestask.data.MovieRepoImpl
import com.example.tmdbmoviestask.data.local.database.AppDatabase
import com.example.tmdbmoviestask.data.local.dao.MovieDao
import com.example.tmdbmoviestask.data.local.model.MovieEntity
import com.example.tmdbmoviestask.data.remote.api.ApiService
import com.example.tmdbmoviestask.data.remote.mediator.MoviesRemoteMediator
import com.example.tmdbmoviestask.domain.MovieRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule{

    @Singleton
    @Binds
    fun bindMovieRepo(movieRepoImpl: MovieRepoImpl): MovieRepo

}

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object MediatorModule{

    @Singleton
    @Provides
    fun provideMediator(appDatabase: AppDatabase, apiService: ApiService): RemoteMediator<Int, MovieEntity>{
        return MoviesRemoteMediator(apiService, appDatabase)
    }

    @Singleton
    @Provides
    fun providePagingConfig() = PagingConfig(pageSize = 20)

    @Singleton
    @Provides
    fun providePager(pagingConfig : PagingConfig, moviesRemoteMediator : RemoteMediator<Int, MovieEntity>, movieDao: MovieDao) = Pager(
        config = pagingConfig,
        remoteMediator = moviesRemoteMediator ,
        pagingSourceFactory = { movieDao.pagingSource() }
    )
}