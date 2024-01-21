package ru.itmo.filmhub.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.itmo.filmhub.model.entity.MediaCollection
import ru.itmo.filmhub.service.MediaCollectionService
import java.util.*

@RestController
@RequestMapping("/collections")
class MediaCollectionController(
    private val mediaCollectionService: MediaCollectionService,
) {
    @GetMapping
    fun getCollections(): ResponseEntity<List<MediaCollection>> {
        return ResponseEntity.status(200).body(mediaCollectionService.getAllCollections())
    }

    @GetMapping("/{collection_id}")
    fun getCollectionById(
        @PathVariable(name = "collection_id", required = true) collectionId: UUID,
    ): ResponseEntity<MediaCollection> {
        return ResponseEntity.status(200).body(mediaCollectionService.getCollectionById(collectionId))
    }
}