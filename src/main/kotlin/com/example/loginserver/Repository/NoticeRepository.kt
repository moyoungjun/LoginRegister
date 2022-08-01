package com.example.loginserver.Repository

import com.example.loginserver.entity.Notice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface NoticeRepository : JpaRepository<Notice,Int>{

}