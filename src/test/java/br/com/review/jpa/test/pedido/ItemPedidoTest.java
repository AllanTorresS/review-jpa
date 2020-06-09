package br.com.review.jpa.test.pedido;

import br.com.jpa.review.model.*;
import br.com.review.jpa.test.manager.EntityManagerGeneric;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemPedidoTest extends EntityManagerGeneric {


    @Test
    public void SalvarItemPedido(){

        Cliente c = entityManager.find(Cliente.class,12);
        Produto p = entityManager.find(Produto.class,1);

        Pedido pe = new Pedido();

        pe.setStatus(StatusPedidosEnum.AGUARDANDO);
        pe.setDataPedido(LocalDateTime.now());
        pe.setTotal(BigDecimal.TEN);
        pe.setCliente(c);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(p.getPreco());
        itemPedido.setProdutoId(p);
        itemPedido.setPedidoId(pe);


        entityManager.persist(pe);
        entityManager.persist(itemPedido);

        Assert.assertNotNull(itemPedido.getId());


    }


}
