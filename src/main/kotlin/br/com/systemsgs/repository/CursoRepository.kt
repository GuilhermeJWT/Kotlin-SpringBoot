package br.com.systemsgs.repository

import br.com.systemsgs.model.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursoRepository: JpaRepository<Curso, Long> {

}