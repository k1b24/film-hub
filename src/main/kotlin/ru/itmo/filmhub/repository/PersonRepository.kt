package ru.itmo.filmhub.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.itmo.filmhub.model.entity.Person
import java.util.UUID

@Repository
interface PersonRepository : JpaRepository<Person, UUID> {
}