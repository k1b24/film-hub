package ru.itmo.filmhub.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID
import ru.itmo.filmhub.model.entity.MediaCollection
import java.util.Optional

@Repository
interface MediaCollectionRepository : JpaRepository<MediaCollection, UUID> {
}