package br.com.jpa.review.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum SexoEnum {
    MASCULINO("Masculino",1),
    FEMININO("Feminino",2);

    private String descricao;
    private Integer valor;


    SexoEnum(String descricao, int valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
