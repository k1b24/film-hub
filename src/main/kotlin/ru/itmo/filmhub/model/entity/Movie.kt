package ru.itmo.filmhub.model.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "movies")
class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,

    val name: String,

    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(
        name = "director_id",
        referencedColumnName = "id",
    )
    val director: Person? = null,

    @Column(name = "release_date")
    val releaseDate: Instant,

    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(
        name = "studio_id",
        referencedColumnName = "id",
    )
    val studio: Studio? = null,

    @Column(name = "imdb_rating")
    val imdbRating: Int,

    @Column(name = "kinopoisk_id")
    val kinopoiskId: Int?,

    @ManyToMany
    @JoinTable(
        name = "movies_availabilities_by_subscriptions",
        joinColumns = [JoinColumn(name = "movie_id")],
        inverseJoinColumns = [JoinColumn(name = "subscription_id")],
    )
    val validSubscriptions: MutableList<Subscription> = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "movies_collections",
        joinColumns = [JoinColumn(name = "movie_id")],
        inverseJoinColumns = [JoinColumn(name = "collection_id")],
    )
    val includedIn: MutableList<MediaCollection> = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "movies_genres",
        joinColumns = [JoinColumn(name = "movie_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")],

    )
    val genres: MutableList<Genre> = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "movies_actors",
        joinColumns = [JoinColumn(name = "movie_id")],
        inverseJoinColumns = [JoinColumn(name = "actor_id")],

    )
    val actors: MutableList<Person> = mutableListOf(),
)