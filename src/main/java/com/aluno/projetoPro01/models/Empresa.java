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
@Table(name = Empresa.TABLE_NAME)
public class Empresa {

    public interface CreateEmpresa {}
    public interface UpdateEmpresa {}

    public static final String TABLE_NAME = "empresas";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome_empresa", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateEmpresa.class)
    private String nomeEmpresa;

    @Column(name = "descricao", length = 1000, nullable = false)
    @NotNull(groups = CreateEmpresa.class)
    private String descricao;

    @Column(name = "cnpj", length = 18, nullable = false, unique = true)
    @NotNull(groups = CreateEmpresa.class)
    private String cnpj;

    @Column(name = "website_url", length = 150)
    private String websiteUrl;

    @Column(name = "data_fundacao")
    private LocalDate dataFundacao;

    @Column(name = "setor", length = 100)
    private String setor;

    // Construtor vazio (obrigatório para JPA)
    public Empresa() {
    }

    // Construtor completo (7 atributos)
    public Empresa(Long id, String nomeEmpresa, String descricao, String cnpj, String websiteUrl, LocalDate dataFundacao, String setor) {
        this.id = id;
        this.nomeEmpresa = nomeEmpresa;
        this.descricao = descricao;
        this.cnpj = cnpj;
        this.websiteUrl = websiteUrl;
        this.dataFundacao = dataFundacao;
        this.setor = setor;
    }

    // Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getWebsiteUrl() {
        return this.websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public LocalDate getDataFundacao() {
        return this.dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getSetor() {
        return this.setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
