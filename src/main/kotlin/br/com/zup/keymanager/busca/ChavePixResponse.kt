package br.com.zup.keymanager.busca

import br.com.zup.ListaChavePixResponse
import java.time.LocalDateTime
import java.time.ZoneOffset

class ChavePixResponse(chavePix: ListaChavePixResponse.ChavePix) {

    val id = chavePix.pixId
    val chave = chavePix.chave
    val tipo = chavePix.tipo
    val tipoDeConta = chavePix.tipoDeConta
    val criadaEm = chavePix.criadaEm.let {
        LocalDateTime.ofEpochSecond(
                it.seconds,
                it.nanos,
                ZoneOffset.UTC)
    }
}