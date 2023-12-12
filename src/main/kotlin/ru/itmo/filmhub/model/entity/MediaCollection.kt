package ru.itmo.filmhub.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "collections")
data class MediaCollection(
    @Column(name = "name", nullable = false)
    var name: String? = null,
    @Column(name = "description", nullable = false)
    var description: String? = null,
    @JsonIgnore
    @ManyToMany(mappedBy = "includedIn", fetch = FetchType.LAZY)
    @JsonManagedReference
    val movies: MutableList<Movie> = mutableListOf()
) : BaseEntity()
