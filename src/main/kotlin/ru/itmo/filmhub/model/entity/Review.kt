package ru.itmo.filmhub.model.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "reviews")
data class Review(
    val text: String = "",
    val rating: Int = 0,
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    val movie: Movie? = null,
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    val author: User? = null,
) : BaseEntity()