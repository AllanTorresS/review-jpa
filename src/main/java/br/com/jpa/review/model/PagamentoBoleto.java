package br.com.jpa.review.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pagamento_boleto")
public class PagamentoBoleto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum status;

    @Column(name = "codigo_barras")
    private String codigoBarras;

}
