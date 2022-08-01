package com.example.loginserver.response

import com.example.loginserver.entity.User
import java.time.LocalDateTime

data class RegisterResponse(
    val timestamp: LocalDateTime,
    val name:String,
    val username:String,
){
    constructor(user:User): this(
        timestamp = user.createdAt,
        name = user.name,
        username = user.username,
    )
}
