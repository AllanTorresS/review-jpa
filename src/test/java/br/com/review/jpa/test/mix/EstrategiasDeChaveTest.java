package br.com.review.jpa.test.mix;

import br.com.jpa.review.model.*;
import br.com.review.jpa.test.manager.EntityManagerGeneric;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class EstrategiasDeChaveTest extends EntityManagerGeneric {

    /**
     * sobre as duas outras estrategias nada de novo
     * - auto(escolhe a melhor entre sequence,identity,table)
     * - identity (autoincremento)
     */
    @Test
    public void estrategiaSequence(){
        Categoria c = new Categoria();

        c.setNome("Cozinha");

        entityManager.merge(c);

    }
    @Test
    public void estrategiaTable(){
        Cliente c = new Cliente();

        c.setNome("Allan Torres");
        c.setSexo(SexoEnum.FEMININO);

         entityManager.persist(c);
       Cliente cliente = entityManager.find(Cliente.class, 12);

    }

}
