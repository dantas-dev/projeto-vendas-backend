package br.com.dantas.projeto.model.dto;

import br.com.dantas.projeto.model.entities.CategoriaEntity;
import br.com.dantas.projeto.model.entities.ClienteEntity;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private Integer id;

    private String nome;

    public ClienteDTO() {}

    public ClienteDTO(ClienteEntity obj) {
        id = obj.getId();
        nome = obj.getNome();
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
}
