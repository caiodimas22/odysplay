package com.aluno.projetoPro01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = Pedido.TABLE_NAME)
public class Pedido {

    public interface CreatePedido {}
    public interface UpdatePedido {}

    public static final String TABLE_NAME = "pedidos";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "descricao", length = 250, nullable = false)
    @NotNull(groups = CreatePedido.class)
    @NotEmpty(groups = CreatePedido.class)
    @Size(groups = CreatePedido.class, min = 5, max = 250)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @NotNull(groups = CreatePedido.class)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Item> itens = new ArrayList<>();

    // Construtor vazio
    public Pedido() {
    }

    // Construtor com parâmetros
    public Pedido(Long id, String descricao, Cliente cliente) {
        this.id = id;
        this.descricao = descricao;
        this.cliente = cliente;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
