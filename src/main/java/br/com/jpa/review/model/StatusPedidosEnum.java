package br.com.jpa.review.model;

public enum StatusPedidosEnum {

    AGUARDANDO("Aguardando",1),
    CANCELADO("Cancelado",2),
    PAGO("Pago",3);

    private String descricao;
    private Integer valor;


    StatusPedidosEnum(String descricao, int valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
