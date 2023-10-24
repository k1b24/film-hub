package ru.itmo.filmhub.model.entity

import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "subscriptions")
class Subscription(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    val name: String,
    val price: Int,
    val description: String,
    @ManyToMany(mappedBy = "validSubscriptions")
    val availableMovies: MutableList<Movie> = mutableListOf(),

)
