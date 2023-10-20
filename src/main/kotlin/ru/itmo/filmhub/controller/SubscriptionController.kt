package ru.itmo.filmhub.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping()
class SubscriptionController {

    @PostMapping("/user/{userId}/subscription/{subscriptionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun postSubscriptionForUser(
        @PathVariable userId: UUID,
        @PathVariable subscriptionId: UUID,
    ) {
        throw NotImplementedError()
    }

}