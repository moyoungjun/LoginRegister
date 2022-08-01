package com.example.loginserver.response

import java.time.LocalDateTime

data class AuthResponse(

    val tokenType: String="Bearer",
    val token: String,
    val expiresTime: LocalDateTime

)