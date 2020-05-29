package br.com.jpa.review.model;

public enum StatusPagamentoEnum {
    PROCESSANDO ("Processando",1),
    CANCELADO("Cancelado",2),
    RECEBIDO("Recebido",3);

    private String descricao;
    private Integer valor;


    StatusPagamentoEnum(String descricao, int valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
