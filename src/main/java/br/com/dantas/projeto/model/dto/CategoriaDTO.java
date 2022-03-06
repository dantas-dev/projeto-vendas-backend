package br.com.dantas.projeto.model.dto;

import br.com.dantas.projeto.model.entities.CategoriaEntity;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private Integer id;

    private String nome;

    public CategoriaDTO() {}

    public CategoriaDTO(CategoriaEntity obj) {
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
