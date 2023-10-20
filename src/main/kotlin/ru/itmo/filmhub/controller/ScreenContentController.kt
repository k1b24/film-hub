package ru.itmo.filmhub.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.itmo.filmhub.model.entity.MediaCollection
import ru.itmo.filmhub.model.response.MovieCardResponse
import ru.itmo.filmhub.model.response.MovieId
import ru.itmo.filmhub.model.response.MovieReviewResponse
import ru.itmo.filmhub.service.MediaCollectionService
import java.util.UUID

@RestController
@RequestMapping("/user-content")
class ScreenContentController(
    @Autowired
    val service: MediaCollectionService
) {

    @GetMapping("/recomendations")
    suspend fun getStartPageMovies(): List<MovieId> {
        throw NotImplementedError()
    }

    @GetMapping("/movie/{movieId}/card")
    suspend fun getMovieCard(
        @PathVariable movieId: UUID,
    ): MovieCardResponse {
        throw NotImplementedError()
    }

    @GetMapping("/collection/{collectionId}/related-content")
    suspend fun getCollectionRelatedContent(
        @PathVariable collectionId: UUID,
    ) {
        throw NotImplementedError()
    }

    @GetMapping("/person/{personId}/related-content/")
    suspend fun getPersonRelatedContent(
        @PathVariable personId: UUID,
    ): List<MovieCardResponse> {
        throw NotImplementedError()
    }

    @GetMapping("/genre/{genreId}/related-content")
    suspend fun getGenreRelatedContent(
        @PathVariable genreId: UUID,
    ): List<MovieCardResponse> {
        throw NotImplementedError()
    }

    @GetMapping("/studio/{studioId}/related-content")
    suspend fun getStudioRelatedContent(
        @PathVariable studioId: UUID,
    ): List<MovieCardResponse> {
        throw NotImplementedError()
    }

    @GetMapping("/movie/{movieId}/reviews")
    suspend fun getMovieReviews(
        @PathVariable movieId: UUID,
    ): List<MovieReviewResponse> {
        throw NotImplementedError()
    }

    //todo переместить в будущем
    @PostMapping()
    fun createCollection(
        @RequestBody collection: MediaCollection
    ) {
        service.addCollection(collection)
    }
}