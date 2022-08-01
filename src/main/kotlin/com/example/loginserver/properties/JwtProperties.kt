package com.example.loginserver.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

// jwt(토큰) 환경설정, 들어가는 값
@ConstructorBinding
@ConfigurationProperties("jwt")
class JwtProperties (
    val secretKey: String,
    val expiration: Long,
    val refreshExpiration: Long
    )