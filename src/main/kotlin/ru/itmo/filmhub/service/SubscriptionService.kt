package ru.itmo.filmhub.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.itmo.filmhub.config.DefaultConfigurationProperties
import ru.itmo.filmhub.model.entity.Subscription
import ru.itmo.filmhub.model.entity.User
import ru.itmo.filmhub.repository.SubscriptionRepository
import ru.itmo.filmhub.repository.UserRepository
import java.util.UUID

@Service
class SubscriptionService(
    private val subscriptionRepository: SubscriptionRepository,
    private val userRepository: UserRepository,
    private val defaultConfigurationProperties: DefaultConfigurationProperties,
) {

    @Transactional
    fun saveSubscriptionForUser(username: String, subscriptionId: UUID): User {
        val user = userRepository.findByUsername(username).orElseThrow()
        val subscription = subscriptionRepository.findById(subscriptionId).orElseThrow()
        user.subscription = subscription
        return userRepository.save(user)
    }

    fun getSubscriptionByUsername(username: String): Subscription =
        subscriptionRepository.findByUsername(username)

    fun getAllSubscriptions(): List<Subscription> {
        return subscriptionRepository.findAll()
    }

    fun getDefaultSubscription(): Subscription =
        subscriptionRepository.findById(defaultConfigurationProperties.defaultSubscriptionId).orElseThrow()
}