package br.com.systemsgs.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicoDTOForm (

    @field:NotEmpty(message = "Titulo deve ser Informado!")
    @field:Size(min = 5, max = 100, message = "Titulo deve conter de 5 a 100 Caracteres!")
    val titulo: String,

    @field:NotEmpty(message = "Mensagem deve ser Informado!")
    val mensagem: String,

    @field:NotNull(message = "ID Curso deve ser Informado!")
    val idCurso: Long,

    @field:NotNull(message = "ID Autor deve ser Informado!")
    val idAutor: Long
)