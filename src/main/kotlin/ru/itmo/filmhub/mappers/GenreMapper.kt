package ru.itmo.filmhub.mappers

import ru.itmo.filmhub.messages.AddGenreRequest
import ru.itmo.filmhub.model.entity.Genre

fun AddGenreRequest.toEntity(): Genre {
    return Genre(
        name = this.name
    )
}
