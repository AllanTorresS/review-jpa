package br.com.jpa.review.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descrição;

    private BigDecimal preco;
}
