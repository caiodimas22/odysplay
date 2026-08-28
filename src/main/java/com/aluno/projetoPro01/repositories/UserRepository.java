package com.aluno.projetoPro01.repositories;

import com.aluno.projetoPro01.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Aqui você pode adicionar métodos de busca customizados se precisar no futuro, por exemplo:
    // Optional<User> findByUsername(String username);
}
