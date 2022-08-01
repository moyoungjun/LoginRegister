package com.example.loginserver.request
import com.example.loginserver.annotation.UniqueUserName
import javax.validation.constraints.NotBlank

data class RegisterRequest(

    @field:NotBlank(message = "비밀번호를 입력하세요.")
    val password : String,
    @field:NotBlank(message = "이름을 입력하세요.")
    val name : String?,
    @field:NotBlank(message = "닉네임을 입력하세요.")
    @field:UniqueUserName
    val username : String?,

)
