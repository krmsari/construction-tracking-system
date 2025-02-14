package com.kerem.authservice.dto.exception.response

data class ErrorResponse(
    private val errorCode:String,
    private val errorMessage:String
)