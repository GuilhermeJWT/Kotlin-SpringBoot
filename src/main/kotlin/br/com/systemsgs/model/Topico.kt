package br.com.systemsgs.model

import java.time.LocalDateTime
import javax.persistence.*
@Entity
data class Topico(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var titulo: String,

    var mensagem: String,

    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "topico")
    val respostas: List<Respostas> = ArrayList(),

    @Enumerated(value = EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

    @ManyToOne
    val curso: Curso,

    @ManyToOne
    val autor: Usuario

)
