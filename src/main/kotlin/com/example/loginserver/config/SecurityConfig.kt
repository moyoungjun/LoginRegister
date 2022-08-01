package com.example.loginserver.config

import com.example.loginserver.request.JwtRequestFilter
import com.example.loginserver.security.JwtAuthentiactionEntryPoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

//securitu 환경설정.
@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtAuthenticationEntryPoint: JwtAuthentiactionEntryPoint,
    private val jwtRequestFilter: JwtRequestFilter
) {
    //Securityfilter 환경 설정
    @Bean
    @Throws(Exception::class)
    fun filterChain(http:HttpSecurity): SecurityFilterChain{
        http.httpBasic().disable() //rest api 만 사용 하므로 httpbasic 사용 안함.
            .csrf().disable() // csrf 보안 토큰 사용 안함
            .authorizeRequests()// 인증 권한
            .antMatchers("/auth/**","/loginserver").permitAll() //인증 권한 설정, 페이지 인증 없이 다 허용
            .antMatchers("/**").authenticated()// 이외 모든 페이지 인증
            .and()
            .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()  // 오류메세지를 jwtAuthentiacitonEntryPoint 로
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() //토큰 사용 중이므로 세션 사용 안함.
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }
    //비밀번호 해쉬 암호화 Bean에 저장.
    @Bean
    fun passwordencoder():PasswordEncoder{
        return BCryptPasswordEncoder()
    }


}