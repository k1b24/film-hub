package ru.itmo.filmhub.model.entity

import java.time.Instant
import java.util.UUID

data class Movie(
    val id: UUID,
    val name: String,
    val directorId: UUID?,
    val releaseDate: Instant,
    val studioId: UUID?,
    val imdbRating: Int,
    val kinopoiskId: Int?,

)