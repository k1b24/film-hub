package ru.itmo.filmhub.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import ru.itmo.filmhub.model.entity.Subscription
import ru.itmo.filmhub.model.entity.User
import ru.itmo.filmhub.service.SubscriptionService
import java.util.*

@RestController
@RequestMapping("/subscriptions")
class SubscriptionController(
    private val service: SubscriptionService,
) {

    @PostMapping("/{subscription_id}")
    fun saveSubscriptionForUser(
        @PathVariable(name = "subscription_id", required = true) subscriptionId: UUID,
        authentication: Authentication
    ): ResponseEntity<User> =
        ResponseEntity.status(200).body(service.saveSubscriptionForUser(authentication.name, subscriptionId))

    @GetMapping("/user")
    fun getUserSubscription(
        authentication: Authentication
    ) = ResponseEntity.status(200).body(service.getSubscriptionByUsername(authentication.name))

    @GetMapping
    fun getAllSubscriptions(): ResponseEntity<List<Subscription>> =
        ResponseEntity.status(200).body(service.getAllSubscriptions())
}