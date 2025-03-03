package com.example.tmdbmoviestask.data.mapper

import com.example.tmdbmoviestask.data.local.model.MovieEntity
import com.example.tmdbmoviestask.data.remote.model.MovieDto
import com.example.tmdbmoviestask.domain.model.Movie

fun MovieDto.toMovieEntity(page : Int): MovieEntity {
    return MovieEntity(
        id = id,
        overview = overview,
        originalLanguage = original_language,
        originalTitle = original_title,
        video = video,
        title = title,
        posterPath = poster_path,
        backdropPath = backdrop_path,
        releaseDate = release_date,
        popularity = popularity,
        voteAverage = vote_average,
        adult = adult,
        voteCount = vote_count,
        page = page
    )
}

fun MovieEntity.toMovie(): Movie {
    return Movie(
        id = id,
        overview = overview,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        video = video,
        title = title,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        popularity = popularity,
        voteAverage = voteAverage,
        adult = adult,
        voteCount = voteCount
    )
}

fun MovieEntity?.toMovieOrNull(): Movie? {
    return if (this == null){
        return null
    }else{
        Movie(
            id = id,
            overview = overview,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            video = video,
            title = title,
            posterPath = posterPath,
            backdropPath = backdropPath,
            releaseDate = releaseDate,
            popularity = popularity,
            voteAverage = voteAverage,
            adult = adult,
            voteCount = voteCount
        )
    }
}