package ru.itmo.filmhub.model.entity

import java.util.UUID

data class Subscription(
    val id: UUID,
    val name: String,
    val price: Int,
    val description: String,

)
