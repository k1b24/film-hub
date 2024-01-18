package ru.itmo.filmhub.messages

data class AddReviewRequest(
    val text: String,
    val rating: Int,
)