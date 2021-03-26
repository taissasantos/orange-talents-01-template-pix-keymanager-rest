package br.com.zup.keymanager.busca

import br.com.zup.CarregaChavePixResponse
import io.micronaut.core.annotation.Introspected
import io.micronaut.validation.Validated
import java.time.ZoneOffset
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import java.time.Instant
import java.time.LocalDateTime

@Validated
@Introspected
class DetalheChaveResponse(chaveResponse: CarregaChavePixResponse) {

    @field:NotBlank
    val pixId = chaveResponse.pixId

    @field:NotBlank
    val clienteId = chaveResponse.clientId

    @field:NotBlank
    val tipoDeChave = chaveResponse.pixId

    @field:NotBlank
    val chave = chaveResponse.chave.toString()

    @field:NotNull
    val conta = ContaResponse(
            chaveResponse.chave.conta.instituicao,
            chaveResponse.chave.conta.nomeDoTitular,
            chaveResponse.chave.conta.cpfDoTitular,
            chaveResponse.chave.conta.agencia,
            chaveResponse.chave.conta.numeroDaConta,
            chaveResponse.chave.tipo

    )
    val criadaEm = chaveResponse.chave.criadaEm.let {
        LocalDateTime.ofInstant(Instant.ofEpochSecond(it.seconds, it.nanos.toLong()), ZoneOffset.UTC)
    }
}