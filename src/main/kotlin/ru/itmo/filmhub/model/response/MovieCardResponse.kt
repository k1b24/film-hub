package ru.itmo.filmhub.model.response

import java.time.Instant

data class MovieCardResponse(
    val name: String,
    val releaseDate: Instant,
    val imdbRating: Int,
    val kpId: Int,
    val directorName: String,
    val directorId: String,
    val studioName: String,
    val studioId: String,
)
