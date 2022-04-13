package br.com.systemsgs.model

import java.time.LocalDateTime

data class Topico(

    var id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val respostas: List<Respostas> = ArrayList(),
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val curso: Curso,
    val autor: Usuario

)
