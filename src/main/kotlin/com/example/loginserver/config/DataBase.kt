package com.example.loginserver.config

import com.example.loginserver.Repository.UserRepository
import com.example.loginserver.entity.User
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DataBase {

    @Bean
    fun initDataBase(userRepository: UserRepository) = CommandLineRunner{

    }

}