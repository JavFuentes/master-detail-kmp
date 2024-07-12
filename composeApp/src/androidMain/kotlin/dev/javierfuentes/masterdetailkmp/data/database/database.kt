package dev.javierfuentes.masterdetailkmp.data.database

import dev.javierfuentes.`master-detail-kmp`.data.database.DATABASE_NAME
import dev.javierfuentes.`master-detail-kmp`.data.database.MoviesDatabase
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<MoviesDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath(DATABASE_NAME)

    return Room.databaseBuilder(
        context = appContext,
        name = dbFile.absolutePath
    )
}