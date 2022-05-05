package br.com.systemsgs.controller

import br.com.systemsgs.dto.AtualizacaoTopicoForm
import br.com.systemsgs.dto.TopicoDTOForm
import br.com.systemsgs.dto.TopicoView
import br.com.systemsgs.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
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
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm):ResponseEntity<TopicoView>{
        val topicoView = service.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }

    @PostMapping("/salvar")
    fun cadastrar(@RequestBody @Valid form: TopicoDTOForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoView>{
        val topicoView = service.cadastrar(form)
        val uri = uriBuilder.path("/topico/pesquisar/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        service.delete(id)
    }

}