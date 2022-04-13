package br.com.systemsgs.controller

import br.com.systemsgs.dto.TopicoDTO
import br.com.systemsgs.model.Topico
import br.com.systemsgs.service.TopicoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topico")
class TopicoController (private val service: TopicoService){

    @GetMapping("/listar")
    fun listar(): List<Topico>{
        return service.listar()
    }

    @GetMapping("/pesquisar/{id}")
    fun buscarPorId(@PathVariable id: Long): Topico{
        return service.buscarPorId(id)
    }

    @PostMapping("/salvar")
    fun cadastrar(@RequestBody dto: TopicoDTO){
        service.cadastrar(dto)
    }

}