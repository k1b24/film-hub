package ru.itmo.filmhub.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ru.itmo.filmhub.messages.AddMovieRequest
import ru.itmo.filmhub.model.entity.Movie
import ru.itmo.filmhub.service.MovieService
import java.util.*

@RestController
class MovieController(
    @Autowired
    val service: MovieService,
) {
    @PostMapping("/admin/movies")
    @ResponseStatus(HttpStatus.OK)
    fun addMovie(
        @RequestBody request: AddMovieRequest,
    ): ResponseEntity<Movie> = // todo изменить на AddMovieResponse
        ResponseEntity.status(200).body(service.addNewMovie(request))

    @GetMapping("/movies/{movie_id}")
    fun getMovieById(
        @PathVariable(name = "movie_id", required = true) movieId: UUID,
    ): ResponseEntity<Movie> {
        return ResponseEntity.status(200).body(service.getMovieById(movieId))
    }

    @GetMapping("/movies/popular")
    fun getPopularMovies(): ResponseEntity<List<Movie>> = ResponseEntity.status(200).body(service.getPopularMovies())
}