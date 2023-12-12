package ru.itmo.filmhub.model.entity

import ru.itmo.filmhub.model.enums.Country
import javax.persistence.*

@Entity
@Table(name = "studios")
data class Studio(
    var name: String = "",
    var country: Country = Country.UNDEFINED,
    var description: String = "-",
) : BaseEntity()