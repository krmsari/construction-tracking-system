package com.kerem.authservice.dto.user.request.abstracts

import jakarta.persistence.MappedSuperclass


@MappedSuperclass
abstract class BaseUserDTO {
    open val email: String=""
    open val password: String=""
}