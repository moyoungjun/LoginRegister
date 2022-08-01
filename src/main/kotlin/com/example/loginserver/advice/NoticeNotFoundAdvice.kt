package com.example.loginserver.advice

import com.example.loginserver.exception.NoticeNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class NoticeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NoticeNotFoundException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun NoticeNotFoundHandler(noticeNotFoundException: NoticeNotFoundException):String?{
        return noticeNotFoundException.message
    }

}