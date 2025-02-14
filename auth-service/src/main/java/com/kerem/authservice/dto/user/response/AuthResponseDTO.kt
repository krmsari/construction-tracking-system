package com.kerem.authservice.dto.user.response
data class AuthResponseDTO(
    val token: String,
    val email: String,
    val role: String
)
