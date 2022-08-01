package com.example.loginserver.exception

class NoticeNotFoundException(value: Any):RuntimeException("공지사항 정보가 없다 {$value}") {
}