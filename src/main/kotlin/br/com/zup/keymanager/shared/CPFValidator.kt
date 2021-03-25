package br.com.zup.keymanager.shared

import org.hibernate.validator.constraints.br.CPF
import java.lang.annotation.Documented
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Documented
@Constraint(validatedBy = [])
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@CPF
annotation class CPFValidator(
        val message: String = "CPF inválido.",
        val groups: Array<KClass<Any>> = [],
        val payload: Array<KClass<Payload>> = []
)