package com.example.loginserver.service

import com.example.loginserver.Repository.UserRepository
import com.example.loginserver.entity.User
import com.example.loginserver.exception.UserNotFoundException
import com.example.loginserver.properties.JwtProperties
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import javax.crypto.SecretKey
import io.jsonwebtoken.*
import io.jsonwebtoken.Claims
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import java.sql.Date
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import javax.annotation.PostConstruct

@Service
class JwtService(
    private val jwtProperties: JwtProperties,
    private val userRepository: UserRepository

) {
    //yml 파일에서 시크릿키를 가져옴.
    lateinit var secretKey: SecretKey
    //@PostConstruct 인스턴스 생성시 바로 실행 되는 생성자
    @PostConstruct
    fun init(){
        secretKey = Keys.hmacShaKeyFor(jwtProperties.secretKey.toByteArray(StandardCharsets.UTF_8))
    }
    //토큰 발급, claims 으로 정보 전달
    fun generateToken(user: User): String {
        val claims :Claims = Jwts.claims().setSubject(user.username)
        val time = LocalDateTime.now()
        val expiration = jwtProperties.expiration
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(Timestamp.valueOf(time))
            .setExpiration(Timestamp.valueOf(time.plusSeconds(expiration)))
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact()
    }
    @Throws(Exception::class)
    private fun getAllClaims(token: String): Claims{
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).body
    }

    fun getExpiration(token: String): LocalDateTime {
        val expiration = getAllClaims(token).expiration
        return expiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
    }

    fun getUserName(token: String): String{
        val claims = getAllClaims(token)
        return claims.subject
    }
    @Throws(Exception::class)
    fun validateToken(token: String) : Boolean{
        val claims = getAllClaims(token)
        val expiration = claims.expiration
        return expiration.after(Date.valueOf(LocalDate.now()))
    }
    //username을 이용해 토큰 발급.
    fun authentication(token: String) : Authentication{
        val username= getUserName(token)
        val usernametokenfind = userRepository.findByUsername(username)?:throw UserNotFoundException(username)
        //filter -> UsernamePasswordAuthentication,
        return UsernamePasswordAuthenticationToken(usernametokenfind,null,usernametokenfind.authorities)
    }


}