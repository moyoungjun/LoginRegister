package com.example.loginserver.advice

import com.example.loginserver.response.ErrorResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@RestControllerAdvice
class ResponseEntityExceptionAdvice: ResponseEntityExceptionHandler(){

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errors = HashMap<String, String>()
        ex.bindingResult.allErrors.forEach { error ->
            if (error is FieldError) {
                val fieldName = error.field
                val errorMessage = error.defaultMessage
                errors[fieldName] = errorMessage!!
            } else {
                val fieldName = error.arguments?.last().toString()
                val errorMessage = error.defaultMessage
                errors[fieldName] = errorMessage!!
            }
        }
        val result : ResponseEntity<Any> = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ErrorResponse(
                    status = HttpStatus.BAD_REQUEST,
                    message = errors
            )
        )
        return result
    }

}