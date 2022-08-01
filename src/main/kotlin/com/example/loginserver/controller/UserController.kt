package com.example.loginserver.controller

import com.example.loginserver.entity.User
import com.example.loginserver.response.UserDetailResponse
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user")
class UserController (

        ){

    //AuthenticationPricipal으로 토큰이 발급된 유저를 가져와 발급된 토큰으로 필터를 거쳐서 인증되어짐..
    @GetMapping("/me")
    fun MyInfomation(@AuthenticationPrincipal user: User) : UserDetailResponse{
        val tokenauth = UserDetailResponse(user)
        return tokenauth

    }

}