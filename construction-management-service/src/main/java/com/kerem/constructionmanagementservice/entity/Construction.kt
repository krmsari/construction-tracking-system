package com.kerem.constructionmanagementservice.entity

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.kerem.constructionmanagementservice.util.CustomLocalDateDeserializer
import jakarta.persistence.*
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "construction")
data class Construction(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id:UUID?=null,
    @Column(nullable = false, unique = true)
    var name:String="",
    var address:String="",
    @JsonDeserialize(using = CustomLocalDateDeserializer::class)
    var startDate:LocalDate?=null,
    @JsonDeserialize(using = CustomLocalDateDeserializer::class)
    var endDate:LocalDate?=null,
    var numberOfBasements:Int=0,
    var numberOfFloors:Int=0,
    var estimatedCost:Double=0.0,

    @Column(name = "site_manager_id")
    var siteManagerId: UUID?=null,
    @Column(name = "structural_engineer_id")
    var structuralEngineerId: UUID?=null,
    @Column(name = "project_manager_id")
    var projectManagerId: UUID?=null,
    @Column(name = "constructor_id")
    var constructor: UUID?=null,
)
