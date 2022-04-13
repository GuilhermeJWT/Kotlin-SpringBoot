package br.com.systemsgs.service

import br.com.systemsgs.dto.TopicoDTOForm
import br.com.systemsgs.dto.TopicoView
import br.com.systemsgs.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(), private val cursoService: CursoService, private val usuarioService: UsuarioService) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t -> TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )}.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico =  topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.dataCriacao,
            status = topico.status
        )
    }

    fun cadastrar(dto: TopicoDTOForm) {
        topicos = topicos.plus(Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscarPorId(dto.idCurso),
            autor = usuarioService.buscarPorId(dto.idAutor)
        ))
    }


    /*
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
     */

}