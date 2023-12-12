package ru.itmo.filmhub.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "movies")
data class Movie(
    val name: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(
        name = "director_id",
        referencedColumnName = "id",
    )
    val director: Person? = null,

    @Column(name = "release_date")
    val releaseDate: Instant? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(
        name = "studio_id",
        referencedColumnName = "id",
    )
    val studio: Studio? = null,

    @Column(name = "imdb_rating", nullable = false)
    val imdbRating: Int = 0,

    @Column(name = "kinopoisk_id")
    val kinopoiskId: Int? = 0,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "movies_availabilities_by_subscriptions",
        joinColumns = [JoinColumn(name = "movie_id")],
        inverseJoinColumns = [JoinColumn(name = "subscription_id")],
    )
    @JsonManagedReference
    val validSubscriptions: MutableList<Subscription> = mutableListOf(),

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "movies_collections",
        joinColumns = [JoinColumn(name = "movie_id")],
        inverseJoinColumns = [JoinColumn(name = "collection_id")],
    )
    @JsonBackReference
    val includedIn: MutableList<MediaCollection> = mutableListOf(),

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "movies_genres",
        joinColumns = [JoinColumn(name = "movie_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")],

    )
    @JsonManagedReference
    val genres: MutableList<Genre> = mutableListOf(),

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "movies_actors",
        joinColumns = [JoinColumn(name = "movie_id")],
        inverseJoinColumns = [JoinColumn(name = "actor_id")],

    )
    @JsonManagedReference
    val actors: MutableList<Person> = mutableListOf(),
) : BaseEntity()