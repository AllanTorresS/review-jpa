package br.com.jpa.review.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class EnderecoEntregaPedido {

    @Column(name = "end_cep")
    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String cidade;

    private String bairro;
}
