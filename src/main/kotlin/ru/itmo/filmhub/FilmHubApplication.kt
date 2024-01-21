package ru.itmo.filmhub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import ru.itmo.filmhub.config.DefaultConfigurationProperties
import ru.itmo.filmhub.config.RsaKeyProperties

@SpringBootApplication
@EnableConfigurationProperties(
	RsaKeyProperties::class,
	DefaultConfigurationProperties::class
)
class FilmHubApplication

fun main(args: Array<String>) {
	runApplication<FilmHubApplication>(*args)
}
