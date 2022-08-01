package com.example.loginserver.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity {
    @CreatedDate
    @Column(nullable = false)
    open var createdAt: LocalDateTime = LocalDateTime.MIN
        protected  set
    @LastModifiedDate
    open var updatedAt : LocalDateTime = LocalDateTime.MAX
        protected  set
}