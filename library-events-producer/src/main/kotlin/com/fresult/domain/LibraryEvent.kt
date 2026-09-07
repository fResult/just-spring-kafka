package com.fresult.domain

import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull

data class LibraryEvent(
    val libraryEventId: Int?,
    val libraryEventType: LibraryEventType?,
    @field:NotNull
    @field:Valid
    val book: Book?,
)
