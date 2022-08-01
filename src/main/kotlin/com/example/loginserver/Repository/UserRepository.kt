package com.example.loginserver.Repository

import com.example.loginserver.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:JpaRepository<User,Int> {
    //username이 존재하는지 true false 리턴.
    fun existsByUsername(username: String):Boolean
    //username을 받아와 User로 리턴, 없다면 Null
    fun findByUsername(username: String): User?

  }