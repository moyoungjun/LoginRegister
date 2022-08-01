package com.example.loginserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing


@SpringBootApplication
@EnableJpaAuditing
@ConfigurationPropertiesScan("com.example.loginserver.properties")
class LoginServerApplication
fun main(args: Array<String>) {
    runApplication<LoginServerApplication>(*args)
}
