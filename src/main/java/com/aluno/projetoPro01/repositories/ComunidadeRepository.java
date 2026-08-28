package com.aluno.projetoPro01.repositories;

import com.aluno.projetoPro01.models.Comunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunidadeRepository extends JpaRepository<Comunidade, Long> {
}
