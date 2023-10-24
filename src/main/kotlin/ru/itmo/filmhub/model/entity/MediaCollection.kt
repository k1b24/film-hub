package ru.itmo.filmhub.model.entity

import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "collections")
class MediaCollection(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    val name: String,
    val description: String,
    @ManyToMany(mappedBy = "includedIn")
    val movies: MutableList<Movie> = mutableListOf(),

)
