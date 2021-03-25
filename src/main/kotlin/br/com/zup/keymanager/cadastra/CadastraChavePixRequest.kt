package br.com.zup.keymanager.cadastra

import br.com.zup.RegistraChavePixRequest
import br.com.zup.keymanager.shared.ValidPixKey
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import java.util.*

@ValidPixKey
@Introspected
class CadastraChavePixRequest(
        @field:NotNull val tipoDeChave: TipoChaveRequest?,
        @field:Size(max = 77) val chave: String,
        @field:NotNull val tipoDeConta: TipoContaRequest?
) {

    fun toGrpc(clientId: UUID): RegistraChavePixRequest {
        return RegistraChavePixRequest.newBuilder()
                .setClientId(clientId.toString())
                .setTipoDeChave(tipoDeChave?.grpcEnum)
                .setChave(chave)
                .setTipoDeConta(tipoDeConta?.grpcEnum)
                .build()
    }
}