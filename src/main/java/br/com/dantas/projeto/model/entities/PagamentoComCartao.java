package br.com.dantas.projeto.model.entities;

import br.com.dantas.projeto.model.enums.EstadoPagamento;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pagamentocomcartao")
public class PagamentoComCartao extends PagamentoEntity{

    private Integer numeroDeParcelas;

    public PagamentoComCartao() {}

    public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento, PedidoEntity pedido, Integer numeroDeParcelas) {
        super(id, estadoPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
