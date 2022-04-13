package br.com.systemsgs.controller

import br.com.systemsgs.model.Curso
import br.com.systemsgs.model.Topico
import br.com.systemsgs.model.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topico")
class TopicoController {

    @GetMapping("/listar")
    fun listar(): List<Topico>{
        val topico = Topico(
            id = 1,
            titulo = "Curso de Kotlin",
            mensagem = "Variaveis do Kotlin",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programação"),
            autor = Usuario(id = 1, nome = "Guilherme", email = "gui@gmail.com")
        )
        return Arrays.asList(topico)
    }

}