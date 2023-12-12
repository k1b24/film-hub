package ru.itmo.filmhub.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.itmo.filmhub.model.entity.User
import java.util.UUID

@Repository
interface UserRepository : JpaRepository<User, UUID> {
}