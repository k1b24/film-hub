package ru.itmo.filmhub.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.itmo.filmhub.model.entity.Subscription
import ru.itmo.filmhub.model.entity.User
import ru.itmo.filmhub.service.SubscriptionService
import java.util.*

@RestController
@RequestMapping()
class SubscriptionController(
    private val service: SubscriptionService,
) {

    @PostMapping("/users/{user_id}/subscriptions/{subscription_id}")
    fun saveSubscriptionForUser(
        @PathVariable(name = "user_id", required = true) userId: UUID,
        @PathVariable(name = "subscription_id", required = true) subscriptionId: UUID,
    ): ResponseEntity<User> {
        return ResponseEntity.status(200).body(service.saveSubscriptionForUser(userId, subscriptionId))
    }

    @GetMapping("/subscriptions")
    fun getAllSubscriptions(): ResponseEntity<List<Subscription>> {
        return ResponseEntity.status(200).body(service.getAllSubscriptions())
    }

}