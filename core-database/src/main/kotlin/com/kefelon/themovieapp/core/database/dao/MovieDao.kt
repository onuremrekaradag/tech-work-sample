import androidx.room.*
import com.kefelon.themovieapp.core.model.MovieDetail

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_detail")
    fun getAll(): List<MovieDetail>

    @Delete
    fun delete(movieDetail: MovieDetail)

    @Insert
    fun insertMovie(movieDetail: MovieDetail)
}
