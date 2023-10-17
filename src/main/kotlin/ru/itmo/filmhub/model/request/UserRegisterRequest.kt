package ru.itmo.filmhub.model.request

data class UserRegisterRequest(
    val login: String,
    val password: String,
    val fullName: String,
    val phoneNumber: String,
    val email: String,
)
