package com.example.loginserver.controller

import com.example.loginserver.Repository.UserRepository
import com.example.loginserver.entity.User
import com.example.loginserver.exception.UserNotFoundException
import com.example.loginserver.request.RegisterRequest
import com.example.loginserver.response.RegisterResponse
import com.example.loginserver.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid


@RestController
@RequestMapping("/loginserver")

class RegisterController(
    val repository: UserRepository,
    val service : UserService
) {
    @GetMapping
   fun a (): MutableList<User> {
        val result = repository.findAll()
        return result
    }
    @GetMapping("/{id}")
    fun userid(@PathVariable id: Int): User? {
        val result2 = repository.findById(id)
            .orElseThrow{UserNotFoundException(id)}
        return result2
    }

    @PostMapping
    fun userregister(@Valid @RequestBody registerrequest: RegisterRequest): RegisterResponse {

        val result = service.register(registerrequest)

        return result
    }
}