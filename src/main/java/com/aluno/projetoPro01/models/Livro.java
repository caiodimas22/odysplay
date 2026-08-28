package com.aluno.projetoPro01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = Livro.TABLE_NAME)
public class Livro {

    public interface CreateLivro {}
    public interface UpdateLivro {}

    public static final String TABLE_NAME = "livros";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "titulo", length = 150, nullable = false)
    @NotNull(groups = CreateLivro.class)
    @NotEmpty(groups = CreateLivro.class)
    @Size(groups = CreateLivro.class, min = 2, max = 150)
    private String titulo;

    @Column(name = "isbn", length = 20, nullable = false, unique = true)
    @NotNull(groups = CreateLivro.class)
    @NotEmpty(groups = CreateLivro.class)
    @Size(groups = CreateLivro.class, min = 10, max = 20)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    @NotNull(groups = CreateLivro.class)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "editora_id", nullable = false)
    @NotNull(groups = CreateLivro.class)
    private Editora editora;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    @NotNull(groups = CreateLivro.class)
    private Categoria categoria;

    // Construtor vazio (obrigatório para JPA)
    public Livro() {
    }

    // Construtor com parâmetros
    public Livro(Long id, String titulo, String isbn, Autor autor, Editora editora, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editora = editora;
        this.categoria = categoria;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Métodos equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
