package br.com.systemsgs.service

import br.com.systemsgs.model.Curso
import br.com.systemsgs.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso{
        return repository.getOne(id)
    }

}