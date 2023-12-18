package ru.itmo.filmhub.service

import org.springframework.stereotype.Service
import ru.itmo.filmhub.mappers.toEntity
import ru.itmo.filmhub.messages.AddGenreRequest
import ru.itmo.filmhub.model.entity.Genre
import ru.itmo.filmhub.model.entity.Movie
import ru.itmo.filmhub.repository.GenreRepository
import ru.itmo.filmhub.repository.MovieRepository
import java.util.UUID

@Service
class GenreService(
    val genreRepository: GenreRepository,
    val movieRepository: MovieRepository,

) {
    fun saveGenre(addGenreRequest: AddGenreRequest): Genre {
        return genreRepository.save(addGenreRequest.toEntity())
    }

    fun getAllGenres(): List<Genre> {
        return genreRepository.findAll()
    }

    fun getMoviesByGenreId(id: UUID): List<Movie> {
        return movieRepository.findAllByGenreId(id)
    }
}