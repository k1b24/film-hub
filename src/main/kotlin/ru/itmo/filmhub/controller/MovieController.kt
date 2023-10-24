package ru.itmo.filmhub.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import ru.itmo.filmhub.messages.AddMovieRequest
import ru.itmo.filmhub.model.entity.Movie
import ru.itmo.filmhub.service.MovieService

@Controller
@RequestMapping("/admin/movie")
class MovieController(
    @Autowired
    val service: MovieService,
) {
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    fun addMovie(
        @RequestBody request: AddMovieRequest,
    ): ResponseEntity<Movie> = // todo изменить на AddMovieResponse
        ResponseEntity.status(200).body(service.addNewMovie(request))

}