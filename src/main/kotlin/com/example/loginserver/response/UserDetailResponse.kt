package com.example.loginserver.response

import com.example.loginserver.entity.User


data class UserDetailResponse(
    val id: Int,
    val username: String,
    val name: String,
) {
    constructor(user: User): this(

        id = user.id?:0,
        username= user.username,
        name = user.name
    )
}