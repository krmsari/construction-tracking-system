package com.kerem.authservice.dto.user.request

import com.kerem.authservice.dto.user.request.abstracts.BaseUserDTO
import java.beans.ConstructorProperties

data class UserRegisterDTO @ConstructorProperties("email","password","roleName") constructor(
    override var email: String,
    override var password: String,
    var roleName: String,
) : BaseUserDTO()
