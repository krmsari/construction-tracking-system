package com.kerem.constructionmanagementservice.dto.user

import java.util.UUID

data class UserDTO(
    val id: UUID,
    val email: String,
    val password: String,
)
