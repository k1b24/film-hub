package ru.itmo.filmhub.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.itmo.filmhub.messages.AddReviewRequest
import ru.itmo.filmhub.service.ReviewService
import java.util.*

@RestController("/reviews")
class ReviewController(
    private val reviewService: ReviewService,
) {
    @PostMapping("/{movie_id}")
    fun addReview(
        @RequestBody addReviewRequest: AddReviewRequest,
        @PathVariable(name = "movie_id", required = true) movieId: UUID,
        authentication: Authentication,
    ) = ResponseEntity.status(200).body(reviewService.addReviewToMovie(addReviewRequest, authentication.name, movieId))

    @GetMapping("/{movie_id}")
    fun findReviewsByMovieId(
        @PathVariable(name = "movie_id", required = true) movieId: UUID,
    ) = ResponseEntity.status(200).body(reviewService.findReviewsByMovieId(movieId))
}