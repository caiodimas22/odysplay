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
@Table(name = Categoria.TABLE_NAME)
public class Categoria {

    public interface CreateCategoria {}
    public interface UpdateCategoria {}

    public static final String TABLE_NAME = "categorias";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateCategoria.class)
    @NotEmpty(groups = CreateCategoria.class)
    @Size(groups = CreateCategoria.class, min = 2, max = 100)
    private String nome;

    @Column(name = "descricao", length = 250, nullable = false)
    @NotNull(groups = CreateCategoria.class)
    @NotEmpty(groups = CreateCategoria.class)
    @Size(groups = CreateCategoria.class, min = 5, max = 250)
    private String descricao;

    // Construtor vazio (obrigatório para JPA)
    public Categoria() {
    }

    // Construtor com parâmetros
    public Categoria(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Métodos equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
