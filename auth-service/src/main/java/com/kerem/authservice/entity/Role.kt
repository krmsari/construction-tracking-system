package com.kerem.authservice.entity

import com.kerem.authservice.entity.abstracts.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = "roles")
data class Role(
    @Column(nullable = false, unique = true)
    val name: String = ""
): BaseEntity()
