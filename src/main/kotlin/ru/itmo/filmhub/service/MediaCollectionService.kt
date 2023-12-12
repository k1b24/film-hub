package ru.itmo.filmhub.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.itmo.filmhub.repository.MediaCollectionRepository
import ru.itmo.filmhub.model.entity.MediaCollection
import java.util.*

@Service
class MediaCollectionService(
    @Autowired
    val repository: MediaCollectionRepository,
) {
    fun addCollection(collection: MediaCollection): MediaCollection {
        return repository.save(collection)
    }

    fun getAllCollections(): List<MediaCollection> {
        return repository.findAll()
    }

    fun getCollectionById(id: UUID): MediaCollection {
        return repository.findById(id).orElseThrow()
    }
}