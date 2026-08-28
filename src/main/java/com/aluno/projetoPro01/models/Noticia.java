package com.aluno.projetoPro01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = Noticia.TABLE_NAME)
public class Noticia {

    public interface CreateNoticia {}
    public interface UpdateNoticia {}

    public static final String TABLE_NAME = "noticias";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "titulo", length = 150, nullable = false)
    @NotNull(groups = CreateNoticia.class)
    private String titulo;

    @Column(name = "autor", length = 100, nullable = false)
    @NotNull(groups = CreateNoticia.class)
    private String autor;

    @Column(name = "conteudo", columnDefinition = "TEXT", nullable = false)
    @NotNull(groups = CreateNoticia.class)
    private String conteudo;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDateTime dataPublicacao;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "visualizacoes")
    private Integer visualizacoes;

    // Construtor vazio (obrigatório para JPA)
    public Noticia() {
    }

    // Construtor completo (7 atributos)
    public Noticia(Long id, String titulo, String autor, String conteudo, LocalDateTime dataPublicacao, String categoria, Integer visualizacoes) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.conteudo = conteudo;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.visualizacoes = visualizacoes;
    }

    // Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataPublicacao() {
        return this.dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getVisualizacoes() {
        return this.visualizacoes;
    }

    public void setVisualizacoes(Integer visualizacoes) {
        this.visualizacoes = visualizacoes;
    }
}
