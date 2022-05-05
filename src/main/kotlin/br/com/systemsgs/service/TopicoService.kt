package br.com.systemsgs.service

import br.com.systemsgs.dto.AtualizacaoTopicoForm
import br.com.systemsgs.dto.TopicoDTOForm
import br.com.systemsgs.dto.TopicoView
import br.com.systemsgs.exception.NotFoundException
import br.com.systemsgs.mapper.TopicoFormMapper
import br.com.systemsgs.mapper.TopicoViewMapper
import br.com.systemsgs.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(),
                    private val topicoViewMapper: TopicoViewMapper,
                    private val topicoFormMapper: TopicoFormMapper,
                    private val notFoundMessage: String = "Topico não Encontrado!"
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t -> topicoViewMapper.map(t)}.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico =  topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView{
        val topico =  topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        val topicoAtualizado = Topico(id = form.id, titulo = form.titulo, mensagem = form.mensagem, autor = topico.autor, curso = topico.curso, respostas = topico.respostas, status = topico.status, dataCriacao = topico.dataCriacao)
        topicos = topicos.minus(topico).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun cadastrar(form: TopicoDTOForm): TopicoView{
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus((topico))

        return topicoViewMapper.map(topico)
    }

    fun delete(id: Long) {
        val topico =  topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        topicos = topicos.minus(topico)
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