package br.com.zup.keymanager.busca

import br.com.zup.CarregaChavePixRequest
import br.com.zup.CarregaChavePixServiceGrpc
import br.com.zup.ListaChavePixRequest
import br.com.zup.ListaChavePixServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.util.*
import javax.inject.Inject

@Controller("/api/v1/clientes/{idCliente}")
class BuscaChavePixEndpoint(@Inject val buscaClient: CarregaChavePixServiceGrpc.CarregaChavePixServiceBlockingStub,
                            @Inject val listaClient: ListaChavePixServiceGrpc.ListaChavePixServiceBlockingStub) {

    @Get(value = "/pix/{pixId}")
    fun carrega(clienteId: UUID, pixId: UUID): HttpResponse<Any>{

        val chaveResponse = buscaClient.carrega(
                CarregaChavePixRequest.newBuilder()
                .setPixId(CarregaChavePixRequest.FiltroPorPixId.newBuilder()
                        .setClientId(clienteId.toString())
                        .setPixId(pixId.toString())
                        .build())
                        .build())
        return HttpResponse.ok(DetalheChaveResponse(chaveResponse))


    }

    @Get(value = "/pix")
    fun lista(clienteId: UUID): HttpResponse<Any>{

        val pix = listaClient.lista(ListaChavePixRequest.newBuilder()
                .setClientId(clienteId.toString())
                .build())

        val chaves = pix.chavesList.map { ChavePixResponse(it) }
        return HttpResponse.ok(chaves)
    }
}