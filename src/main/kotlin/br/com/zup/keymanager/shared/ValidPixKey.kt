package br.com.zup.keymanager.shared

import br.com.zup.keymanager.cadastra.CadastraChavePixRequest
import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass


@MustBeDocumented
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [ValidPixValidator::class])
annotation class ValidPixKey(
        val message: String = "A Chave pix é inválida.",
        val groups: Array<KClass<Any>> = [],
        val payload: Array<KClass<Payload>> = []
)

@Singleton
class ValidPixValidator: ConstraintValidator<ValidPixKey, CadastraChavePixRequest> {

    override fun isValid(
            value: CadastraChavePixRequest?,
            annotationMetadata: AnnotationValue<ValidPixKey>,
            context: ConstraintValidatorContext): Boolean {

        if( value?.tipoDeChave == null){
            return false
        }

        return value.tipoDeChave.valida(value.chave)
    }


}