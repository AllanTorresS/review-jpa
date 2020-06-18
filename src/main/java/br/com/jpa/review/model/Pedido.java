package br.com.jpa.review.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pedido")
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Column(name = "data_criacao")
    private LocalDateTime dataInsercao;

    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;

    @OneToOne(mappedBy = "pedidoId")
    private NotaFiscal notaFiscalId;

    @OneToOne(mappedBy = "pedidoId")
    private PagamentoCartao pagamentoCartaoId;

    @Enumerated(EnumType.STRING)
    private StatusPedidosEnum status;

    @OneToMany(mappedBy = "pedidoId")
    private List<ItemPedido> itemPedidos;
    private BigDecimal total;

    @Embedded
    private EnderecoEntregaPedido enderecoEntregaPedido;

    @PrePersist
    public void aoInserir(){
        this.dataInsercao = LocalDateTime.now();
    }

    @PreUpdate
    public void aoAtualizar(){
        this.dataAlteracao = LocalDateTime.now();
    }
}
