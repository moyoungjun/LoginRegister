package com.example.loginserver.request

import com.example.loginserver.service.JwtService
import io.jsonwebtoken.JwtException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtRequestFilter(
    private val jwtService: JwtService
):OncePerRequestFilter(){

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain){
        //발급된 토큰을 Authorizaion 헤더에 Bearer타입으로 넣어줄 때 설정 값. ?: 틀리면 다음 필터로 넘어가서 수행.(인증 실패)
        val authorization = request.getHeader("Authorization") ?: return filterChain.doFilter(request, response)
        if (authorization.startsWith("Bearer ")){
            val token = authorization.substring(7)
            try {
                if (jwtService.validateToken(token)){
                    val authentication = jwtService.authentication(token)
                    SecurityContextHolder.getContext().authentication = authentication
//                    val user = authentication.principal as User
                }
            } catch (e:Exception){
                when (e){
                    is java.lang.IllegalArgumentException, is JwtException -> {

                    }
                }
            }
        }
        filterChain.doFilter(request, response)
    }

}