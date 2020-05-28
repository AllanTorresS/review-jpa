package br.com.review.jpa.test.produto;

import br.com.jpa.review.model.Produto;
import br.com.review.jpa.test.manager.EntityManagerGeneric;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProdutoTest extends EntityManagerGeneric {

    @Test
    /**
     * o getReference só vai executar a busca de verdade quando acessar uma
     * porpriedade do objeto, diferente do find que busca logo.
     */
    public void buscarProdutoPorId(){

        Produto p = entityManager.find(Produto.class,1);
//        Produto p = entityManager.getReference(Produto.class,1);

        Assert.assertNotNull(p);
        System.out.println(p.getDescrição());
    }
    @Test
    public void atualizarReferencia(){
        Produto p = entityManager.find(Produto.class,1);

//        Produto p = entityManager.getReference(Produto.class,1);
        p.setDescrição("um ótimo tablet");
        entityManager.refresh(p);
    }

    @Test
    public void salvar(){
        Produto p = new Produto();
        p.setNome("celular xiaomi");
        p.setDescrição("8gb de ram");


        Produto s = entityManager.merge(p);
        Assert.assertNotNull(s.getId());

    }

    @Test
    public void Atualizar(){
        Produto p = entityManager.find(Produto.class,5);
        p.setPreco(new BigDecimal(5000));


    }

}
