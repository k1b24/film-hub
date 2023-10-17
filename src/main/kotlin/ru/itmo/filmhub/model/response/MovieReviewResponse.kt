package ru.itmo.filmhub.model.response

data class MovieReviewResponse(
    val text: String,
    val rating: Int,
    val authorName: String,
)
