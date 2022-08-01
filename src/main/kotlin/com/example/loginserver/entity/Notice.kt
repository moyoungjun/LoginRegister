package com.example.loginserver.entity

import com.example.loginserver.request.NoticeRequestDTO
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
class Notice(
    @Id
    @GeneratedValue
    val id:Int?=null,
    val title: String,
    val content: String,

) {
    constructor(noticeRequestDTO: NoticeRequestDTO):this(
        title = noticeRequestDTO.title,
        content = noticeRequestDTO.content
    )

}