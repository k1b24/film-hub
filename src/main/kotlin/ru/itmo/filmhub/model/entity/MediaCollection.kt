package ru.itmo.filmhub.model.entity

import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "collections")
data class MediaCollection(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,
    @Column
    var name: String,
    var description: String,

)
