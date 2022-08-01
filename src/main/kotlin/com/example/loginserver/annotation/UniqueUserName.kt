package com.example.loginserver.annotation

import com.example.loginserver.validator.UniqueUserNameValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [UniqueUserNameValidator::class])
@Retention(AnnotationRetention.RUNTIME)
annotation class UniqueUserName(
    val message : String = " 중복된 UserName입니다.",
    val groups: Array<KClass<*>> = [],
    val payload : Array<KClass<out Payload>> = [],
)
