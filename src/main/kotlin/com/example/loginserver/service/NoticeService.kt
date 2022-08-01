package com.example.loginserver.service

import com.example.loginserver.Repository.NoticeRepository
import com.example.loginserver.entity.Notice
import com.example.loginserver.request.NoticeRequestDTO
import com.example.loginserver.response.NoticeResponseDTO
import org.springframework.stereotype.Service


@Service
class NoticeService(
    private val repository: NoticeRepository

) {
    fun createNotice(noticeRequestDTO: NoticeRequestDTO): NoticeResponseDTO{

        val createNotice = Notice(noticeRequestDTO)
        repository.save(createNotice)

        return NoticeResponseDTO(createNotice)
    }
}