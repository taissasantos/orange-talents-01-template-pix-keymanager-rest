package br.com.zup.keymanager.factory

import br.com.zup.CarregaChavePixServiceGrpc
import br.com.zup.ListaChavePixServiceGrpc
import br.com.zup.PixServiceGrpc
import br.com.zup.RemoveChavePixServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
class KeyManagerGrpcFactory(@GrpcChannel(value = "keyManager") val channel: ManagedChannel) {

    @Singleton
    fun registraChave() = PixServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun deletaChave() = RemoveChavePixServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun listaChave() = ListaChavePixServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun carregaChave() = CarregaChavePixServiceGrpc.newBlockingStub(channel)
}