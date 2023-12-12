package ru.itmo.filmhub.service

import org.springframework.stereotype.Service
import ru.itmo.filmhub.model.entity.Subscription
import ru.itmo.filmhub.repository.SubscriptionRepository

@Service
class SubscriptionService(
    private val repository: SubscriptionRepository,
) {
    fun getAllSubscriptions(): List<Subscription> {
        return repository.findAll()
    }
}