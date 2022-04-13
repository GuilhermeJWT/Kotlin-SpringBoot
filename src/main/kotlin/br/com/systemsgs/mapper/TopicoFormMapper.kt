package br.com.systemsgs.mapper

import br.com.systemsgs.dto.TopicoDTOForm
import br.com.systemsgs.model.Topico
import br.com.systemsgs.service.CursoService
import br.com.systemsgs.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(private val cursoService: CursoService, private val usuarioService: UsuarioService): Mapper<TopicoDTOForm, Topico> {

    override fun map(t: TopicoDTOForm): Topico {
       return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}