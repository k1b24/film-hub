package ru.itmo.filmhub.model.entity

import ru.itmo.filmhub.model.enums.Country
import java.util.*


data class Studio(
    val id: UUID,
    val name: String,
    val country: Country,
    val description: String,
)