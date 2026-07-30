package com.fresult

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class LibraryEventsProducerApplication {
    @GetMapping("/hello")
    fun hello() = "Hello"
}

fun main(args: Array<String>) {
    runApplication<LibraryEventsProducerApplication>(*args)
}
