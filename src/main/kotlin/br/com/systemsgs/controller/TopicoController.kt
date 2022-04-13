package br.com.systemsgs.controller

import br.com.systemsgs.dto.TopicoDTOForm
import br.com.systemsgs.dto.TopicoView
import br.com.systemsgs.service.TopicoService
import org.springframework.web.bind.annotation.*

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

    @PostMapping("/salvar")
    fun cadastrar(@RequestBody dto: TopicoDTOForm){
        service.cadastrar(dto)
    }

}