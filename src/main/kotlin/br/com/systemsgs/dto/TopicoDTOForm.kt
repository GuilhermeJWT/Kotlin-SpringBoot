package br.com.systemsgs.dto

data class TopicoDTOForm (
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long
)