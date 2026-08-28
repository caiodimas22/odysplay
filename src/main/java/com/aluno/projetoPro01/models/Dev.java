package com.aluno.projetoPro01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = Dev.TABLE_NAME)
public class Dev {

    public interface CreateDev {}
    public interface UpdateDev {}

    public static final String TABLE_NAME = "devs";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "especialidade", length = 100, nullable = false)
    @NotNull(groups = CreateDev.class)
    private String especialidade;

    @Column(name = "data_nascimento", nullable = false)
    @NotNull(groups = CreateDev.class)
    private LocalDate dataNascimento;

    @Column(name = "status", length = 100, nullable = false)
    @NotNull(groups = CreateDev.class)
    private String status;

    @Column(name = "github_url", length = 150)
    private String githubUrl;

    @Column(name = "linkedin_url", length = 150)
    private String linkedinUrl;

    @Column(name = "portfolio_url", length = 150)
    private String portfolioUrl;

    @Column(name = "biografia", columnDefinition = "TEXT")
    private String biografia;

    // Construtor vazio (obrigatório para JPA)
    public Dev() {
    }

    // Construtor completo (8 atributos)
    public Dev(Long id, String especialidade, LocalDate dataNascimento, String status, String githubUrl, String linkedinUrl, String portfolioUrl, String biografia) {
        this.id = id;
        this.especialidade = especialidade;
        this.dataNascimento = dataNascimento;
        this.status = status;
        this.githubUrl = githubUrl;
        this.linkedinUrl = linkedinUrl;
        this.portfolioUrl = portfolioUrl;
        this.biografia = biografia;
    }

    // Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGithubUrl() {
        return this.githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedinUrl() {
        return this.linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getPortfolioUrl() {
        return this.portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public String getBiografia() {
        return this.biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
