package ru.itmo.filmhub.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController {
    @GetMapping("/ping")
    fun ping(auth: Authentication): ResponseEntity<String> {
        return ResponseEntity.status(200).body("pong")
    }
}