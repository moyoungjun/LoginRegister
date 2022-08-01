package com.example.loginserver.service

import com.example.loginserver.Repository.UserRepository
import com.example.loginserver.entity.User
import com.example.loginserver.request.RegisterRequest
import com.example.loginserver.response.RegisterResponse
import org.springframework.security.crypto.password.PasswordEncoder

import org.springframework.stereotype.Service


@Service
class UserService (
    private val userRepository: UserRepository,
    private val passwordEncoder:PasswordEncoder
) {
    fun register(userCreationRequest:RegisterRequest):RegisterResponse{

        var user = User(userCreationRequest)
        user.password = passwordEncoder.encode(user.password)
        userRepository.save(user)
        return RegisterResponse(user)
   }
}