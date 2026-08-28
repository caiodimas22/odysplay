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
@Table(name = Comunidade.TABLE_NAME)
public class Comunidade {

    public interface CreateComunidade {}
    public interface UpdateComunidade {}

    public static final String TABLE_NAME = "comunidades";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateComunidade.class)
    private String nome;

    @Column(name = "regras", columnDefinition = "TEXT", nullable = false)
    @NotNull(groups = CreateComunidade.class)
    private String regras;

    @Column(name = "descricao", length = 1000, nullable = false)
    @NotNull(groups = CreateComunidade.class)
    private String descricao;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "membros_count")
    private Integer membrosCount;

    @Column(name = "topico_principal", length = 100)
    private String topicoPrincipal;

    // Construtor vazio (obrigatório para JPA)
    public Comunidade() {
    }

    // Construtor completo (7 atributos)
    public Comunidade(Long id, String nome, String regras, String descricao, LocalDateTime dataCriacao, Integer membrosCount, String topicoPrincipal) {
        this.id = id;
        this.nome = nome;
        this.regras = regras;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.membrosCount = membrosCount;
        this.topicoPrincipal = topicoPrincipal;
    }

    // Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegras() {
        return this.regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getMembrosCount() {
        return this.membrosCount;
    }

    public void setMembrosCount(Integer membrosCount) {
        this.membrosCount = membrosCount;
    }

    public String getTopicoPrincipal() {
        return this.topicoPrincipal;
    }

    public void setTopicoPrincipal(String topicoPrincipal) {
        this.topicoPrincipal = topicoPrincipal;
    }
}
