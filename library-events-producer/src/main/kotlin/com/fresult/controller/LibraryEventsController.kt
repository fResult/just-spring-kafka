package com.fresult.controller

import com.fresult.domain.LibraryEvent
import com.fresult.domain.LibraryEventType
import com.fresult.producer.LibraryEventProducer
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/v1/library-events")
class LibraryEventsController(
    private val libraryEventProducer: LibraryEventProducer,
) {
    private val log = LoggerFactory.getLogger(LibraryEventsController::class.java)

    @PostMapping
    fun postLibraryEvent(
        @RequestBody @Valid libraryEvent: LibraryEvent,
    ): ResponseEntity<LibraryEvent> {
        log.info("Received event for library {}", libraryEvent)
        val event = libraryEvent.copy(libraryEventType = LibraryEventType.ADD)

        // invoke kafka producer
        // libraryEventProducer.sendLibraryEvent(event)

        return ResponseEntity.created(URI.create("/v1/library-events/${event.libraryEventId}")).body(event)
    }
}
