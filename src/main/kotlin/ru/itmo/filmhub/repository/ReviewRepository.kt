package ru.itmo.filmhub.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.itmo.filmhub.model.entity.Review
import java.util.UUID

@Repository
interface ReviewRepository : JpaRepository<Review, UUID> {

    @Query(
        """
            SELECT * FROM reviews
            WHERE movie_id = :movieId
        """,
        nativeQuery = true
    )
    fun findAllByMovieId(movieId: UUID): List<Review>
}