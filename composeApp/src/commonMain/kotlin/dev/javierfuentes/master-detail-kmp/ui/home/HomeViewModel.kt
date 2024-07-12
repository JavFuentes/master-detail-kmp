import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.javierfuentes.`master-detail-kmp`.data.MoviesService

class HomeViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            repository.movies.collect{
                if(it.isNotEmpty()) {
                    state = UiState(loading = false, movies = it)
                }
            }
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movies: List<Movie> = emptyList()
    )
}

