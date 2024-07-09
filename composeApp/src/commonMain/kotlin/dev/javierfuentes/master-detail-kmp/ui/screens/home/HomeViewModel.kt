import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.javierfuentes.`master-detail-kmp`.data.MoviesService


class HomeViewModel(
    private val moviesService: MoviesService
) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(
                loading = false,
                movies = moviesService.fetchPopularMovies().results.map { it.toDomainMovie() }
            )
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movies: List<Movie> = emptyList()
    )
}

private fun RemoteMovie.toDomainMovie() = Movie(
    id = id,
    title = title,
    poster = "https://image.tmdb.org/t/p/w500$posterPath"
)