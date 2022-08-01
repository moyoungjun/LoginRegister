package com.example.loginserver.exception

class UserNotFoundException(id: Any):RuntimeException("아이디를 찾을 수 없습니다. $id") {}