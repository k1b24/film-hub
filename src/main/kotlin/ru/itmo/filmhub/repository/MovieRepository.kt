package ru.itmo.filmhub.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.itmo.filmhub.model.entity.Movie
import ru.itmo.filmhub.model.entity.projections.ShortMovieProjection
import java.util.Optional
import java.util.UUID

@Repository
interface MovieRepository : JpaRepository<Movie, UUID> {

    @Query(
        """
        SELECT m FROM Movie m
        WHERE m.id = :id
        """
    )
    fun shortById(id: UUID): Optional<ShortMovieProjection>

    @Query(
        """
           SELECT m FROM Movie m
           LEFT JOIN FETCH m.genres g
           WHERE g.id = :genreId
        """
    )
    fun findAllByGenreId(genreId: UUID): List<Movie>

    @Query(
        """
            SELECT m FROM Movie m ORDER BY m.localMovieRating
        """
    )
    fun findPopularByRating(pageable: Pageable): List<Movie>
}