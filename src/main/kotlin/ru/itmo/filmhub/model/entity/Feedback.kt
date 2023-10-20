package ru.itmo.filmhub.model.entity

import java.util.UUID

data class Feedback(
    val id: UUID,
    val text: String,
    val rating: Int,
    val movieId: UUID,
    val authorId: UUID,

)