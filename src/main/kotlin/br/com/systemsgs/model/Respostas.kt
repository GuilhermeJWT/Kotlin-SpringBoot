package br.com.systemsgs.model

import java.time.LocalDateTime

data class Respostas (
    val id: Long?,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    val topico: Topico,
    val solucao: Boolean
)