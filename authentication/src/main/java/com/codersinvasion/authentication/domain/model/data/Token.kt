package com.codersinvasion.authentication.domain.model.data

data class Token(
    val access: String,
    val refresh: String
)
