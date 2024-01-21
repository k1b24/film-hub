package ru.itmo.filmhub.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.itmo.filmhub.model.entity.Subscription
import java.util.UUID

@Repository
interface SubscriptionRepository : JpaRepository<Subscription, UUID> {

    @Query(
        """
            SELECT * FROM subscriptions
            RIGHT JOIN users u on subscriptions.id = u.subscription_id
            WHERE u.username = :username
        """,
        nativeQuery = true
    )
    fun findByUsername(username: String): Subscription
}