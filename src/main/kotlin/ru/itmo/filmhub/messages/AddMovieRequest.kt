package ru.itmo.filmhub.messages

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant
import java.util.UUID

class AddMovieRequest(
    val name: String,
    @JsonProperty("director_id")
    val directorId: UUID,
    @JsonProperty("release_date")
    val releaseDate: Instant,
    @JsonProperty("studio_id")
    val studioId: UUID,
    @JsonProperty("imdb_rating")
    val imdbRating: Int,
    @JsonProperty("kinopoisk_id")
    val kinopoiskId: Int?,
    @JsonProperty("cover_url")
    val coverUrl: String,
)