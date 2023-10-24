package ru.itmo.filmhub.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.itmo.filmhub.messages.AddMovieRequest
import ru.itmo.filmhub.model.entity.Movie
import ru.itmo.filmhub.repository.MovieRepository

@Service
class MovieService(
    @Autowired
    val repository: MovieRepository
) {
    fun addNewMovie(addMovieRequest: AddMovieRequest): Movie {
        val movie = Movie(
            name = addMovieRequest.name,
            releaseDate = addMovieRequest.releaseDate,
            imdbRating = addMovieRequest.imdbRating,
            kinopoiskId = addMovieRequest.kinopoiskId,
        )
        return repository.save(movie)
    }
}