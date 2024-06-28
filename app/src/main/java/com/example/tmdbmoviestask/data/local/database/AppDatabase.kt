package com.example.tmdbmoviestask.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbmoviestask.data.local.dao.MovieDao
import com.example.tmdbmoviestask.data.local.model.MovieEntity

@Database(
    version = 22,
    entities = [
        MovieEntity::class
    ],
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}
