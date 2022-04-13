package br.com.systemsgs.controller

import br.com.systemsgs.model.Topico
import br.com.systemsgs.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

}