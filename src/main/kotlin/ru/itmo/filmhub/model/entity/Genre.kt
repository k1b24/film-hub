package ru.itmo.filmhub.model.entity

import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "genres")
class Genre(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    val name: String,
    @ManyToMany(mappedBy = "genres")
    val movies: MutableList<Movie> = mutableListOf(),

)