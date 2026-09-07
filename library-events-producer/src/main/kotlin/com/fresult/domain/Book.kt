package com.fresult.domain

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class Book(
    @field:NotNull
    val bookId: Int?,
    @field:NotBlank
    val bookName: String?,
    @field:NotBlank
    val bookAuthor: String?,
)
