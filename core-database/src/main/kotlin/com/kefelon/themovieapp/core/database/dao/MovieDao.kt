import androidx.room.*
import com.kefelon.themovieapp.core.model.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getAll(): List<Movie>

    @Delete
    fun delete(movie: Movie)
}
