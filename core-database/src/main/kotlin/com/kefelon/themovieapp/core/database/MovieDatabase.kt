import androidx.room.Database
import androidx.room.RoomDatabase
import com.kefelon.themovieapp.core.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
