package ru.itmo.filmhub.model.entity

import ru.itmo.filmhub.model.enums.Country
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "studios")
data class Studio(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    val name: String,
    val country: Country,
    val description: String,
)