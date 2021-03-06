package br.com.dantas.projeto.model.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pedido pendente"),
    QUITADO(2, "Pedifo quitado"),
    CANCELADO(3, "Pedido cancelado");


    private int cod;
    private String descricao;


    EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }


    public static EstadoPagamento toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (EstadoPagamento x : EstadoPagamento.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
