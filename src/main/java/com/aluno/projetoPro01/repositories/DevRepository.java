package com.aluno.projetoPro01.repositories;

import com.aluno.projetoPro01.models.Dev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevRepository extends JpaRepository<Dev, Long> {
}
