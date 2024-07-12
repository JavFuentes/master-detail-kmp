package dev.javierfuentes.`master-detail-kmp`.data.database

import Movie
import MoviesDao
import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_NAME = "movies.db"

interface DB {
    fun clearAllTables() {}
}

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDatabase : RoomDatabase(), DB {
    abstract fun moviesDao(): MoviesDao

    override fun clearAllTables() { }
}

