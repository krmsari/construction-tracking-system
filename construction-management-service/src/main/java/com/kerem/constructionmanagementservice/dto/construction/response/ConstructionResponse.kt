package com.kerem.constructionmanagementservice.dto.construction.response

import com.kerem.constructionmanagementservice.entity.Construction
import java.time.LocalDate
import java.util.*

data class ConstructionResponse(
    val name:String,
    val address:String,
    val startDate:LocalDate,
    val endDate: LocalDate,
    val numberOfBasements:Int,
    val numberOfFloors:Int,
    val estimatedCost:Double,
    val siteManagerId: UUID,
    val structuralEngineerId: UUID,
    val projectManagerId: UUID,
    val constructor: UUID,
)