package br.com.systemsgs.controller

import br.com.systemsgs.dto.AtualizacaoTopicoForm
import br.com.systemsgs.dto.TopicoDTOForm
import br.com.systemsgs.dto.TopicoView
import br.com.systemsgs.service.TopicoService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topico")
class TopicoController (private val service: TopicoService){

    @GetMapping("/listar")
    fun listar(): List<TopicoView>{
        return service.listar()
    }

    @GetMapping("/pesquisar/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView{
        return service.buscarPorId(id)
    }

    @PutMapping("/atualizar")
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm){
        service.atualizar(form)
    }

    @PostMapping("/salvar")
    fun cadastrar(@RequestBody @Valid form: TopicoDTOForm){
        service.cadastrar(form)
    }

    @DeleteMapping("/delete/{id}")
    fun deletar(@PathVariable id: Long){
        service.delete(id)
    }

}