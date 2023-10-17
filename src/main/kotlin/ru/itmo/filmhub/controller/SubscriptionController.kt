package ru.itmo.filmhub.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.*

@RequestMapping()
class SubscriptionController {

    @PostMapping("/user/{userId}/subscription/{subscriptionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun postSubscriptionForUser(
        @PathVariable userId: UUID,

        ) {
        throw NotImplementedError()
    }

}