package com.aluno.projetoPro01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = Item.TABLE_NAME)
public class Item {

    public interface CreateItem {}
    public interface UpdateItem {}

    public static final String TABLE_NAME = "itens";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotNull(groups = CreateItem.class)
    @NotEmpty(groups = CreateItem.class)
    @Size(groups = CreateItem.class, min = 2, max = 100)
    private String nome;

    @Column(name = "quantidade", nullable = false)
    @NotNull(groups = CreateItem.class)
    @Min(value = 1, groups = CreateItem.class)
    private Integer quantidade;

    @Column(name = "preco", nullable = false)
    @NotNull(groups = CreateItem.class)
    @DecimalMin(value = "0.01", groups = CreateItem.class)
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    @NotNull(groups = CreateItem.class)
    private Pedido pedido;

    // Construtor vazio
    public Item() {
    }

    // Construtor com parâmetros
    public Item(Long id, String nome, Integer quantidade, Double preco, Pedido pedido) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.pedido = pedido;
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
