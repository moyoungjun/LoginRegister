package com.example.loginserver.advice

import com.example.loginserver.exception.AuthFailException
import com.example.loginserver.exception.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class AuthFailAdivice {

    @ResponseBody
    @ExceptionHandler(AuthFailException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun userNotFoundHandler(ex : AuthFailException):String?{
        return  ex.message
    }

}