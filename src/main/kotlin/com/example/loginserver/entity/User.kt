package com.example.loginserver.entity

import com.example.loginserver.request.RegisterRequest
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
    @Id
    @GeneratedValue
    var id :Int? = null,

    @Column(nullable = false)
    private var password :String,

    @Column(nullable = false, unique = true)
    private var username: String,

    @Column(nullable = false)
    var name: String,
):BaseTimeEntity(), UserDetails{
    //Body에서 요청하는 값 집어 넣어서 초기화.
    constructor(userCreationRequest:RegisterRequest):this(
        
        password = userCreationRequest.password,
        name = userCreationRequest.name!!,
        username = userCreationRequest.username!!
    )

    constructor(id: Int):this(
        id = id,
        password = " ",
        name = " ",
        username = " ",
    )


    override fun equals(other: Any?): Boolean {
        return if(other is User){
            this.id == other.id && this.username == other.username
        }else{
            false
        }
    }

    fun setPassword(password:String){
        this.password = password
    }
    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableSetOf()
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

}
