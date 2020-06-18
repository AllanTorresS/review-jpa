package br.com.review.jpa.test.mix;

import br.com.jpa.review.model.Cliente;
import br.com.jpa.review.model.Pedido;
import br.com.jpa.review.model.Produto;
import br.com.jpa.review.model.StatusPedidosEnum;
import br.com.review.jpa.test.manager.EntityManagerGeneric;
import org.junit.Test;

import java.math.BigDecimal;

public class CicloDeVidaTest extends EntityManagerGeneric {


    @Test
    public void verificaCache(){
        Produto p = entityManager.find(Produto.class,1);
        System.out.println(p.getDescrição());


        /**
         * como esse mesmo produto já foi chamado antes ele está na memoria
         * logo ele não vai no banco novamente,
         * se quiser que ele va no banco de novo tem que usar close ou clear
         */
        p = entityManager.find(Produto.class,1);
        System.out.println(p.getDescrição());

    }

    @Test(expected = Exception.class)
    public void chamarFlush() {
        try {
            entityManager.getTransaction().begin();

            Pedido pedido = entityManager.find(Pedido.class, 1);
            pedido.setStatus(StatusPedidosEnum.PAGO);

            /*força o envio das coisas para o banco antes do commit*/
            entityManager.flush();

            if (pedido.getStatus() == null) {
                throw new RuntimeException("Pedido ainda não foi pago.");
            }

//            Uma consulta obriga o JPA a sincronizar o que ele tem na memória (sem usar o flush explicitamente).
//            Pedido pedidoPago = entityManager
//                    .createQuery("select p from Pedido p where p.id = 1", Pedido.class)
//                    .getSingleResult();
//            Assert.assertEquals(pedido.getStatus(), pedidoPago.getStatus());

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Test
    public void callback() {
        try {


            Cliente c = entityManager.find(Cliente.class, 12);
            Pedido p = new Pedido();

            p.setCliente(c);
            p.setStatus(StatusPedidosEnum.AGUARDANDO);
            entityManager.persist(p);
            entityManager.flush();



            p.setTotal(BigDecimal.TEN);


        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
