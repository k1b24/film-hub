package ru.itmo.filmhub.service

import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit

@Service
class TokenService (
    private val jwtEncoder: JwtEncoder,
    private val userService: UserService,
) {
    fun generateToken(authentication: Authentication): String {
        println("AAAAAAAAAAAA")
        val now = Instant.now()
        val claimsSet = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plus(1, ChronoUnit.DAYS))
            .subject(authentication.name)
            .claim("subscription", userService.findUserByUsername(authentication.name).subscription)
            .build()
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).tokenValue
    }
}