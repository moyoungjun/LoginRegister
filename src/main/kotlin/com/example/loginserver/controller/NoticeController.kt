package com.example.loginserver.controller

import com.example.loginserver.request.NoticeRequestDTO
import com.example.loginserver.response.NoticeResponseDTO
import com.example.loginserver.service.NoticeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notice")
class NoticeController(
     val noticeService: NoticeService
) {
    @PostMapping
    fun noticeRegister(@RequestBody noticeRequestDTO: NoticeRequestDTO): NoticeResponseDTO{
        val noticeregister = noticeService.createNotice(noticeRequestDTO)
        return noticeregister


    }
}