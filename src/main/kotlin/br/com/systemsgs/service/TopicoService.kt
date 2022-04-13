package br.com.systemsgs.service

import br.com.systemsgs.model.Curso
import br.com.systemsgs.model.Topico
import br.com.systemsgs.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico = Topico(
            id = 1,
            titulo = "Curso de Kotlin",
            mensagem = "Variaveis do Kotlin",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programação"),
            autor = Usuario(id = 1, nome = "Guilherme", email = "gui@gmail.com")
        )
        val topico2 = Topico(
            id = 2,
            titulo = "Curso de Kotlin 2",
            mensagem = "Variaveis do Kotlin 2",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programação"),
            autor = Usuario(id = 1, nome = "Guilherme", email = "gui@gmail.com")
        )
        val topico3 = Topico(
            id = 3,
            titulo = "Curso de Kotlin 3",
            mensagem = "Variaveis do Kotlin 3",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programação"),
            autor = Usuario(id = 1, nome = "Guilherme 3", email = "gui@gmail.com")
        )
        topicos = Arrays.asList(topico, topico2, topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }
}