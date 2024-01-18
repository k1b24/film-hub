package ru.itmo.filmhub.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.itmo.filmhub.model.entity.User
import ru.itmo.filmhub.messages.UserRegisterRequest
import ru.itmo.filmhub.service.UserService
import ru.itmo.filmhub.service.TokenService

@RestController
@RequestMapping("/user")
class AuthenticationController(
    private val userService: UserService,
    private val tokenService: TokenService,
) {
    @PostMapping("/register")
    fun register(
        @RequestBody userRegisterRequest: UserRegisterRequest,
    ): ResponseEntity<User> = ResponseEntity.status(200).body(userService.addUser(userRegisterRequest))

    @PostMapping("/auth")
    fun auth(
        authentication: Authentication,
    ): ResponseEntity<String> = ResponseEntity.status(200).body(tokenService.generateToken(authentication))
}