package ru.itmo.filmhub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FilmHubApplication

fun main(args: Array<String>) {
	runApplication<FilmHubApplication>(*args)
}
