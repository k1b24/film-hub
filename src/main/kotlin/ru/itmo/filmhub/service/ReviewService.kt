package ru.itmo.filmhub.service

import org.springframework.stereotype.Service
import ru.itmo.filmhub.model.entity.Review
import ru.itmo.filmhub.messages.AddReviewRequest
import ru.itmo.filmhub.repository.ReviewRepository
import java.util.UUID

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val movieService: MovieService,
    private val userService: UserService,
) {
    fun findReviewsByMovieId(movieId: UUID): List<Review> =
        reviewRepository.findAllByMovieId(movieId)

    fun addReviewToMovie(addReviewRequest: AddReviewRequest, username: String, movieId: UUID): Review =
        reviewRepository.save(
            Review(
                text = addReviewRequest.text,
                movie = movieService.getMovieById(movieId),
                rating = addReviewRequest.rating,
                author = userService.findUserByUsername(username)
            )
        )

}