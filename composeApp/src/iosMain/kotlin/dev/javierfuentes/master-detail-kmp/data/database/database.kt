import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import dev.javierfuentes.`master-detail-kmp`.data.database.DATABASE_NAME
import dev.javierfuentes.`master-detail-kmp`.data.database.MoviesDatabase
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<MoviesDatabase> {
    val dbFilePath = NSHomeDirectory() + "/$DATABASE_NAME"
    return Room.databaseBuilder<MoviesDatabase>(
        name = dbFilePath,
        factory = { MoviesDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
}