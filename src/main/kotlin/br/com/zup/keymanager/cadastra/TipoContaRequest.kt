package br.com.zup.keymanager.cadastra

import br.com.zup.TipoDeConta

enum class TipoContaRequest (val grpcEnum: TipoDeConta) {

    CONTA_CORRENTE(TipoDeConta.CONTA_CORRENTE),
    CONTA_POUPANCA(TipoDeConta.CONTA_POUPANCA);

}