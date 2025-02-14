package com.kerem.authservice.dto.user.request

import com.kerem.authservice.dto.user.request.abstracts.BaseUserDTO
import java.beans.ConstructorProperties

data class UserLoginDTO @ConstructorProperties("email", "password") constructor(
    override val email: String,
    override val password: String
) : BaseUserDTO()
