package ru.itmo.filmhub.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.itmo.filmhub.model.entity.Subscription
import ru.itmo.filmhub.service.SubscriptionService
import java.util.*

@RestController
@RequestMapping()
class SubscriptionController(
    private val service: SubscriptionService,
) {

    @PostMapping("/user/{userId}/subscription/{subscriptionId}")
    fun postSubscriptionForUser(
        @PathVariable userId: UUID,
        @PathVariable subscriptionId: UUID,
    ) {
        throw NotImplementedError()
    }

    @GetMapping("/subscriptions")
    fun getAllSubscriptions(): ResponseEntity<List<Subscription>> {
        return ResponseEntity.status(200).body(service.getAllSubscriptions())
    }

}