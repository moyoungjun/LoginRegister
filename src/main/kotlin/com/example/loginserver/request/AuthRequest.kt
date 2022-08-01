package com.example.loginserver.request

import javax.validation.constraints.NotBlank

data class AuthRequest(
    @field:NotBlank(message="id 입력해주세요")
    val id: Int,
    @field:NotBlank(message="username을 입력해주세요")
    val username: String?,
    @field:NotBlank(message="password를 입력해주세요")
    val password: String?,

)
