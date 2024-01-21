package ru.itmo.filmhub.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "genres")
data class Genre(
    @Column(name = "name", nullable = false)
    val name: String? = null,
    @ManyToMany(mappedBy = "genres")
    @JsonBackReference
    val movies: MutableList<Movie> = mutableListOf(),
) : BaseEntity()