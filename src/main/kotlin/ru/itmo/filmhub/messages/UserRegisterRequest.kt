package ru.itmo.filmhub.messages

data class UserRegisterRequest(
    val login: String,
    val password: String,
)
