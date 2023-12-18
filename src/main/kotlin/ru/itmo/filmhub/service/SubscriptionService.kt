package ru.itmo.filmhub.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.itmo.filmhub.model.entity.Subscription
import ru.itmo.filmhub.model.entity.User
import ru.itmo.filmhub.repository.SubscriptionRepository
import ru.itmo.filmhub.repository.UserRepository
import java.util.UUID

@Service
class SubscriptionService(
    private val subscriptionRepository: SubscriptionRepository,
    private val userRepository: UserRepository,
) {

    @Transactional
    fun saveSubscriptionForUser(userId: UUID, subscriptionId: UUID): User {
        val user = userRepository.findById(userId).orElseThrow()
        val subscription = subscriptionRepository.findById(subscriptionId).orElseThrow()
        user.subscription = subscription
        return userRepository.save(user)
    }

    fun getAllSubscriptions(): List<Subscription> {
        return subscriptionRepository.findAll()
    }
}