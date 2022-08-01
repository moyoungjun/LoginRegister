package com.example.loginserver.controller

import com.example.loginserver.Repository.UserRepository
import com.example.loginserver.entity.User
import com.example.loginserver.exception.UserNotFoundException
import com.example.loginserver.properties.JwtProperties
import com.example.loginserver.request.AuthRequest
import com.example.loginserver.response.AuthResponse
import com.example.loginserver.service.AuthService
import com.example.loginserver.service.JwtService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/auth/token")
class AuthController(
    private val authService:AuthService,
){
    //username과 password가 일치하다면 토큰 발급.
    @PostMapping
    fun Authorizepost(@RequestBody authrequest: AuthRequest):AuthResponse{
        val result = authService.authorize(authrequest)
        println(result.token)
        return result
    }
}