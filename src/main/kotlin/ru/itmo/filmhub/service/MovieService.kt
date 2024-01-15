package ru.itmo.filmhub.service

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import ru.itmo.filmhub.messages.AddMovieRequest
import ru.itmo.filmhub.model.entity.Movie
import ru.itmo.filmhub.model.response.MovieId
import ru.itmo.filmhub.repository.MovieRepository
import java.awt.print.Pageable
import java.util.UUID

@Service
class MovieService(
    private val repository: MovieRepository,
) {
    fun addNewMovie(addMovieRequest: AddMovieRequest): Movie {
        val movie = Movie(
            name = addMovieRequest.name,
            releaseDate = addMovieRequest.releaseDate,
            imdbRating = addMovieRequest.imdbRating,
            kinopoiskId = addMovieRequest.kinopoiskId,
            coverUrl = addMovieRequest.coverUrl,
        )
        return repository.save(movie)
    }

    fun getMovieById(id: UUID): Movie {
        return repository.findById(id).orElseThrow()
    }

    fun getPopularMovies(): List<Movie> {
        return repository.findPopularByRating(PageRequest.of(0, 3))
    }
}