package com.example.loginserver.exception

class AuthFailException:RuntimeException("아이디와 비밀번호가 일치하지 않습니다.") {
}