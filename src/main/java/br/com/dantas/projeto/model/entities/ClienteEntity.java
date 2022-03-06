package br.com.dantas.projeto.model.entities;

import br.com.dantas.projeto.model.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_clientes")
public class ClienteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String email;

    private String cpf;

    private Integer tipo;

    @OneToMany(mappedBy = "cliente")
    private List<EnderecoEntity> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "telefone")
    private Set<String> telefones = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<PedidoEntity> pedidos = new ArrayList<>();


    public ClienteEntity() {}

    public ClienteEntity(Integer id, String nome, String email, String cpf, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.tipo = (tipo == null) ? null : tipo.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<PedidoEntity> getPedidos() {
        return pedidos;
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }

    public List<EnderecoEntity> getEnderecos() {
        return enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
