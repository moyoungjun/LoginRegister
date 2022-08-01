package com.example.loginserver.response

import com.example.loginserver.entity.Notice
import com.example.loginserver.request.NoticeRequestDTO


class NoticeResponseDTO(
    val id:Int?= null,
    var title: String,
    var content: String
) {
    constructor(notice: Notice):this(
        title=notice.title,
        content = notice.content,


    )

}