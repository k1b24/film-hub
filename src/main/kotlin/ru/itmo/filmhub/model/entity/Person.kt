package ru.itmo.filmhub.model.entity

import ru.itmo.filmhub.model.enums.Country
import java.time.Instant
import java.util.UUID

data class Person(
    val id: UUID,
    val fullname: String,
    val birthdate: Instant?,
    val country: Country,
    val description: String,

)
