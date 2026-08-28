package com.aluno.projetoPro01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = Autor.TABLE_NAME)
public class Autor {

    public interface CreateAutor {}
    public interface UpdateAutor {}

    public static final String TABLE_NAME = "autores";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotNull(groups = CreateAutor.class)
    @NotEmpty(groups = CreateAutor.class)
    @Size(groups = CreateAutor.class, min = 2, max = 100)
    private String nome;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateAutor.class)
    @NotEmpty(groups = CreateAutor.class)
    @Email(groups = CreateAutor.class)
    @Size(groups = CreateAutor.class, max = 100)
    private String email;

    // Construtor vazio (obrigatório para JPA)
    public Autor() {
    }

    // Construtor com parâmetros
    public Autor(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
