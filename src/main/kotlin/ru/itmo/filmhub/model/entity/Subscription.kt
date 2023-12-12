package ru.itmo.filmhub.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "subscriptions")
data class Subscription(
    val name: String = "",
    val price: Int = 0,
    val description: String = "",
    @ManyToMany(mappedBy = "validSubscriptions")
    @JsonBackReference
    val availableMovies: MutableList<Movie> = mutableListOf(),
) : BaseEntity()
