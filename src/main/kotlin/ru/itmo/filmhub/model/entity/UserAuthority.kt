package ru.itmo.filmhub.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "authorities")
@Entity
data class UserAuthority(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    val user: User? = null,
    val authority: String? = null,
)