package com.kerem.authservice.entity

import com.kerem.authservice.entity.abstracts.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(

    @Column(unique = true, nullable = false)
    var email: String = "",

    @Column(nullable = false)
//    @get:JvmName("getPassword_")
    var password: String = "",

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    var role: Role = Role()

) : BaseEntity()
