package ru.itmo.filmhub.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.itmo.filmhub.model.entity.Subscription
import java.util.UUID

@Repository
interface SubscriptionRepository : JpaRepository<Subscription, UUID> {
}