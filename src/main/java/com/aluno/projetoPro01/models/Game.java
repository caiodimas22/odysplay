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
@Table(name = Game.TABLE_NAME)
public class Game {

    public interface CreateGame {}
    public interface UpdateGame {}

    public static final String TABLE_NAME = "games";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome_game_jam", length = 150, nullable = false)
    @NotNull(groups = CreateGame.class)
    private String nomeGameJam;

    @Column(name = "tema", length = 100, nullable = false)
    @NotNull(groups = CreateGame.class)
    private String tema;

    @Column(name = "regras", columnDefinition = "TEXT", nullable = false)
    @NotNull(groups = CreateGame.class)
    private String regras;

    @Column(name = "descricao_game_jam", columnDefinition = "TEXT", nullable = false)
    @NotNull(groups = CreateGame.class)
    private String descricaoGameJam;

    @Column(name = "premios", length = 500, nullable = false)
    @NotNull(groups = CreateGame.class)
    private String premios;

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDateTime dataFim;

    // Construtor vazio (obrigatório para JPA)
    public Game() {
    }

    // Construtor completo (8 atributos)
    public Game(Long id, String nomeGameJam, String tema, String regras, String descricaoGameJam, String premios, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.nomeGameJam = nomeGameJam;
        this.tema = tema;
        this.regras = regras;
        this.descricaoGameJam = descricaoGameJam;
        this.premios = premios;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeGameJam() {
        return this.nomeGameJam;
    }

    public void setNomeGameJam(String nomeGameJam) {
        this.nomeGameJam = nomeGameJam;
    }

    public String getTema() {
        return this.tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getRegras() {
        return this.regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    public String getDescricaoGameJam() {
        return this.descricaoGameJam;
    }

    public void setDescricaoGameJam(String descricaoGameJam) {
        this.descricaoGameJam = descricaoGameJam;
    }

    public String getPremios() {
        return this.premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public LocalDateTime getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
}
