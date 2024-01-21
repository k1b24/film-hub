package ru.itmo.filmhub.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.itmo.filmhub.model.entity.User
import ru.itmo.filmhub.model.entity.UserAuthority
import ru.itmo.filmhub.messages.UserRegisterRequest
import ru.itmo.filmhub.repository.UserRepository

@Service
class UserService(
    private val userRepository: UserRepository,
    private val subscriptionService: SubscriptionService,
    private val passwordEncoder: PasswordEncoder,
) {
    fun addUser(registerRequest: UserRegisterRequest) =
        User(
            name = registerRequest.login,
            email = "submit your email address",
            username = registerRequest.login,
            password = passwordEncoder.encode(registerRequest.password),
            enabled = true,
            subscription = subscriptionService.getDefaultSubscription(),
            phoneNumber = "submit number",
        ).apply {
            authorities.addLast(
                UserAuthority(
                    authority = "user",
                    user = this
                )
            )
            userRepository.save(this)
        }

    fun findUserByUsername(username: String): User =
        userRepository.findByUsername(username).orElseThrow()
}