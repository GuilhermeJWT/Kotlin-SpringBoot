package br.com.systemsgs.service

import br.com.systemsgs.dto.TopicoDTO
import br.com.systemsgs.model.Topico
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(), private val cursoService: CursoService, private val usuarioService: UsuarioService) {

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }

    fun cadastrar(dto: TopicoDTO) {
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