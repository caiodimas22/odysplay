package com.aluno.projetoPro01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = Editora.TABLE_NAME)
public class Editora {

    public interface CreateEditora {}
    public interface UpdateEditora {}

    public static final String TABLE_NAME = "editoras";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotNull(groups = CreateEditora.class)
    @NotEmpty(groups = CreateEditora.class)
    @Size(groups = CreateEditora.class, min = 2, max = 100)
    private String nome;

    @Column(name = "endereco", length = 200, nullable = false)
    @NotNull(groups = CreateEditora.class)
    @NotEmpty(groups = CreateEditora.class)
    @Size(groups = CreateEditora.class, min = 5, max = 200)
    private String endereco;

    // Construtor vazio (obrigatório para JPA)
    public Editora() {
    }

    // Construtor com parâmetros
    public Editora(Long id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Métodos equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editora editora = (Editora) o;
        return Objects.equals(id, editora.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
