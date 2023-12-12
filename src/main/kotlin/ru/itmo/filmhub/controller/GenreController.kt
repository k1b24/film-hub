package ru.itmo.filmhub.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.itmo.filmhub.model.entity.Genre
import ru.itmo.filmhub.model.entity.Movie
import ru.itmo.filmhub.service.GenreService
import java.util.*

@RestController
@RequestMapping("/genres")
class GenreController(
    val genreService: GenreService,
) {
    @GetMapping
    fun getGenres(): ResponseEntity<List<Genre>> {
        return ResponseEntity.status(200).body(genreService.getAllGenres())
    }

    @GetMapping("/{genre_id}")
    fun getMoviesByGenreId(
        @PathVariable(name = "genre_id", required = true) genreId: UUID,
    ): ResponseEntity<List<Movie>> {
        return ResponseEntity.status(200).body(genreService.getMoviesByGenreId(genreId))
    }
}