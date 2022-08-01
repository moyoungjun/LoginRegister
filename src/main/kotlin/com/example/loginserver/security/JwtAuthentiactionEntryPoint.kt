package com.example.loginserver.security

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

//토큰 인증이 안됬을 때 에러.
@Component
class JwtAuthentiactionEntryPoint(

): AuthenticationEntryPoint{

    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        //서버 상태 표시 401 에러, 에러 응답 메세지 Unauthorized
        response?.status = HttpServletResponse.SC_UNAUTHORIZED
        response?.outputStream?.print("Unauthorized")
    }
}