package ru.itmo.filmhub.model.entity

import ru.itmo.filmhub.model.enums.Country
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "personalities")
data class Person(
    @Column(name = "fullname", nullable = false)
    val fullname: String? = null,
    val birthdate: Instant? = null,
    @Enumerated(EnumType.STRING)
    val country: Country = Country.UNDEFINED,
    @Column(name = "description", nullable = false)
    val description: String? = null,
) : BaseEntity()
