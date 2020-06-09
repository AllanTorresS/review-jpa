package br.com.review.jpa.test.categoria;

import br.com.jpa.review.model.Categoria;
import br.com.jpa.review.model.Produto;
import br.com.review.jpa.test.manager.EntityManagerGeneric;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class CategoriaAutoRelacionamentoTest extends EntityManagerGeneric {


    @Test
    public void salvarCategoria() {

        Categoria categoria = new Categoria();
        categoria.setNome("Cama, Mesa, Banho");


        entityManager.persist(categoria);
        Assert.assertNotNull(categoria.getId());
    }

    @Test
    public void salvarAutoRelacionamento() {

        Categoria pai = new Categoria();
        pai.setNome("Eletrônicos");

        Categoria categoria = new Categoria();
        categoria.setNome("celular");
        categoria.setCategoriaPaiId(pai);

        entityManager.persist(pai);
        entityManager.persist(categoria);


    }

    @Test
    public void bucarCategoriaPai() {

        Categoria categoriaBd = entityManager.find(Categoria.class, 70);
        Assert.assertFalse(categoriaBd.getCategorias().isEmpty());
    }


    @Test
    public void salvarMuitosPordutosMuitasCategorias() {

        Produto p = entityManager.find(Produto.class,1);
        Categoria c = entityManager.find(Categoria.class,70);

        p.setCategorias(Arrays.asList(c));

        Assert.assertNotNull(p.getId());

    }
}
