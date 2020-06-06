package br.com.review.jpa.test.pedido;

import br.com.jpa.review.model.Cliente;
import br.com.jpa.review.model.Pedido;
import br.com.jpa.review.model.StatusPedidosEnum;
import br.com.review.jpa.test.manager.EntityManagerGeneric;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoTest extends EntityManagerGeneric {


    @Test
    public void SalvarPedidoDeUmCliente(){

        Cliente c = entityManager.find(Cliente.class,12);

        Pedido p = new Pedido();

        p.setStatus(StatusPedidosEnum.PAGO);
        p.setDataPedido(LocalDateTime.now());
        p.setTotal(BigDecimal.TEN);
        p.setCliente(c);

        entityManager.persist(p);

        Assert.assertNotNull(p.getId());


    }


}
