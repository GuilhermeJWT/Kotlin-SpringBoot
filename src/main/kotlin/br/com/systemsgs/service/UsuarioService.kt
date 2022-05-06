package br.com.systemsgs.service

import br.com.systemsgs.model.Usuario
import br.com.systemsgs.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
    }
}