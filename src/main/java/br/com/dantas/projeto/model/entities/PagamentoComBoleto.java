package br.com.dantas.projeto.model.entities;

import br.com.dantas.projeto.model.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_pagamentocomboleto")
public class PagamentoComBoleto extends PagamentoEntity{

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVenciento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataPagamento;

    public PagamentoComBoleto() {}


    public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, PedidoEntity pedido, Date dataVenciento, Date dataPagamento) {
        super(id, estadoPagamento, pedido);
        this.dataVenciento = dataVenciento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVenciento() {
        return dataVenciento;
    }

    public void setDataVenciento(Date dataVenciento) {
        this.dataVenciento = dataVenciento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
