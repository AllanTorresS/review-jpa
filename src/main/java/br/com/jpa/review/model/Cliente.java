package br.com.jpa.review.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cliente")
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tabela")
    @TableGenerator(name = "tabela", pkColumnName = "sequence_name", pkColumnValue = "cliente", valueColumnName = "next_val",initialValue = 2, allocationSize = 1)
    private Integer id;

    private String nome;

    @Column(name = "sexo")
    private String sexoDescricao;

    @Transient
    private SexoEnum sexo;

    /**
     * Lembrando que essa estrategia com @PrePersist e @PostLoad só
     * está senod usada pq a enum @{@link SexoEnum} possui constrtutores;
     */
    /**
     * antes de persistir, ele pega o objeto SEXO, que é um transient
     * que foi enviado em forma de objeto pelo front e retira dela a descrição.
     *
     * esse pre-persist só funciona se usar o entityManger.persist() como
     * merge nãpo rola.
     */
    @PrePersist
    private void prePersist() {
        this.sexoDescricao = sexo == null ? null : sexo.getDescricao();
    }

    /**
     * quando esse objeto vem do banco, antes ele usa a descrição que está no banco
     * e usa ela para preencher o objeto SEXO do tipo enum.
     */
    @PostLoad
    private void postLoad() {
        this.sexo = SexoEnum.tipoNum(this.sexoDescricao);
    }
}
