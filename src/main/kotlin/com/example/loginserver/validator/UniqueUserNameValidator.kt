package com.example.loginserver.validator

import com.example.loginserver.Repository.UserRepository
import com.example.loginserver.annotation.UniqueUserName
import org.springframework.stereotype.Component
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext


@Component
class UniqueUserNameValidator(
    private val userRepository: UserRepository
): ConstraintValidator<UniqueUserName, String>{

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return !userRepository.existsByUsername(value!!)
    }
}