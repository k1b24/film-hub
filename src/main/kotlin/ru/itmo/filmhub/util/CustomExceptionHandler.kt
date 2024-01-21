package ru.itmo.filmhub.util

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.NoSuchElementException

@ControllerAdvice
class CustomExceptionHandler {
    @ExceptionHandler(NoSuchElementException::class)
    fun handle404(e: Exception): ResponseEntity<*> {
        return ResponseEntity.status(404).body("No such element")
    }

}