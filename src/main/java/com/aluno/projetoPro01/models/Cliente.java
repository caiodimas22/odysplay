package com.aluno.projetoPro01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = Cliente.TABLE_NAME)
public class Cliente {

    public interface CreateCliente {}
    public interface UpdateCliente {}

    public static final String TABLE_NAME = "clientes";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotNull(groups = CreateCliente.class)
    @NotEmpty(groups = CreateCliente.class)
    @Size(groups = CreateCliente.class, min = 2, max = 100)
    private String nome;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateCliente.class)
    @NotEmpty(groups = CreateCliente.class)
    @Email(groups = CreateCliente.class)
    @Size(groups = CreateCliente.class, max = 100)
    private String email;

    @OneToMany(mappedBy = "cliente")
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Pedido> pedidos = new ArrayList<>();

    // Construtor vazio
    public Cliente() {
    }

    // Construtor com parâmetros
    public Cliente(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
