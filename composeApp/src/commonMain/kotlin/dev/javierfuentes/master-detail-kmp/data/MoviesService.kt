package dev.javierfuentes.`master-detail-kmp`.data

import RemoteMovie
import RemoteResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MoviesService(private val client: HttpClient) {
    suspend fun fetchPopularMovies(): RemoteResult {
        return client
            .get("/discover/movie?sort_by=popularity.desc")
            .body<RemoteResult>()
    }

    suspend fun fetchMovieById(id: Int): RemoteMovie {
        return client
            .get("/movie/$id")
            .body<RemoteMovie>()
    }
}