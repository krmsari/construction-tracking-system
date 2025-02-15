package com.kerem.constructionmanagementservice.dto.construction.request

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.kerem.constructionmanagementservice.util.CustomLocalDateDeserializer
import java.time.LocalDate
import java.util.*

data class ConstructionRequest(
    val name:String,
    val address:String,
    @JsonDeserialize(using = CustomLocalDateDeserializer::class)
    val startDate:LocalDate,
    @JsonDeserialize(using = CustomLocalDateDeserializer::class)
    val endDate:LocalDate,
    val numberOfBasements:Int,
    val numberOfFloors:Int,
    val estimatedCost:Double,
    val siteManagerId: UUID,
    val structuralEngineerId: UUID,
    val projectManagerId: UUID,
    val constructor: UUID,
)