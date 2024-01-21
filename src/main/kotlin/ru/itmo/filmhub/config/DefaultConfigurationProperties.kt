package ru.itmo.filmhub.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.UUID

@ConstructorBinding
@ConfigurationProperties("default")
data class DefaultConfigurationProperties(
    val defaultSubscriptionId: UUID,
)