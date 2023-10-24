package ru.itmo.filmhub.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.itmo.filmhub.repository.CollectionRepository
import ru.itmo.filmhub.model.entity.MediaCollection

@Service
class MediaCollectionService(
    @Autowired
    val repository: CollectionRepository,
) {
    fun addCollection(collection: MediaCollection): MediaCollection {
        return repository.save(collection)
    }
}