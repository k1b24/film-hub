package ru.itmo.filmhub.model.entity

import java.util.UUID

data class User(
    val id: UUID,
    val subscriptionId: UUID,
    val name: String,
    val email: String,
    val login: String,
    val password: String,
    val phoneNumber: String,

)
