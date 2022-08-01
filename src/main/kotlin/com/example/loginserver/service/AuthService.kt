package com.example.loginserver.service

import com.example.loginserver.Repository.UserRepository
import com.example.loginserver.exception.AuthFailException
import com.example.loginserver.request.AuthRequest
import com.example.loginserver.response.AuthResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class AuthService (
    val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder, //해쉬 코드암호화.
    private val jwtService: JwtService

){

    fun authorize(authRequest:AuthRequest): AuthResponse{
        //userRepository에서 jpa 문법을 써서 username을 써서 찾고 있다면 일치하는 user반환, 아니면 예외처리.
        val user = userRepository.findByUsername(authRequest.username!!) ?: throw AuthFailException()

        //암호화된 비밀번호에 대해 요청 비밀번호를 round,salt를 이용해 해싱된 비밀번호를 같은결과값으로 비교
        if (!passwordEncoder.matches(authRequest.password,user.password)){
            throw AuthFailException()
        }

        // 토큰 발급
        val gettoken = jwtService.generateToken(user)

        return AuthResponse(token = gettoken, expiresTime = jwtService.getExpiration(gettoken))


    }

}
