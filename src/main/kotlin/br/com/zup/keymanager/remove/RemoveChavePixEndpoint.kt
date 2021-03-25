package br.com.zup.keymanager.remove

import br.com.zup.RemoveChavePixRequest
import br.com.zup.RemoveChavePixServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid
import javax.validation.constraints.NotNull
import java.util.*

@Validated
@Controller("/deleta/pix/{pixId}")
class RemoveChavePixEndpoint(@Inject private val removeChaveClient
: RemoveChavePixServiceGrpc.RemoveChavePixServiceBlockingStub) {

    @Delete("/cliente/{clienteId}")
    fun deleta(@Valid @PathVariable @NotNull pixId: Long, @PathVariable @NotNull clienteId: UUID): HttpResponse<Any> {

        val removeChaveRequest = RemoveChavePixRequest.newBuilder()
                .setPixId(pixId.toString())
                .setClientId(clienteId.toString())
                .build()

        removeChaveClient.remove(removeChaveRequest)

        return HttpResponse.ok()
    }



}