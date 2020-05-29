package br.com.jpa.review.model;

import lombok.Getter;
import lombok.Setter;

import java.util.stream.Stream;

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

    public static SexoEnum tipoNum(String descricao) {
        return Stream.of( values() )
                .filter( value -> value.descricao.equals(descricao) )
                .findFirst()
                .orElse( null );
    }
}
