import dev.javierfuentes.`master-detail-kmp`.data.MoviesService

class MoviesRepository(private val moviesService: MoviesService) {
    suspend fun fetchPopularMovies(): RemoteResult {
        return moviesService.fetchPopularMovies()
    }
}