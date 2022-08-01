package com.example.loginserver.request

import javax.validation.constraints.NotBlank


data class NoticeRequestDTO(
    @field:NotBlank(message = "ID 입력")
    val id:Int,
    @field:NotBlank(message = "제목 입력 ")
    val title:String,
    @field:NotBlank(message = "내용 입력")
    val content: String,


    )
