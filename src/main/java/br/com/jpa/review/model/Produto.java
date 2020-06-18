package br.com.jpa.review.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "produto")
public class Produto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descrição;

    private BigDecimal preco;

    /** não permiti que a data de inserção do registro possa ser alterada apos ser cadastrada*/
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataInsercao;

    /** não permiti que a data de alteração do registro possa ser inserida quando cadastrar um produto*/
    @Column(name = "data_alteracao", insertable = false)
    private LocalDateTime dataAlteracao;

    @OneToMany(mappedBy = "produtoId")
    private List<ItemPedido> itemPedidos;

    @ManyToMany
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;
}
