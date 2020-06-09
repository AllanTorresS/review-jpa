package br.com.review.jpa.test.pedido;

import br.com.jpa.review.model.*;
import br.com.review.jpa.test.manager.EntityManagerGeneric;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

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

    @Test
    public void SalvarPedidoDeUmClienteEVerificaListaDeItemPedidos(){

        Cliente c = entityManager.find(Cliente.class,12);

        Pedido p = new Pedido();

        p.setStatus(StatusPedidosEnum.PAGO);
        p.setDataPedido(LocalDateTime.now());
        p.setTotal(BigDecimal.TEN);
        p.setCliente(c);

        entityManager.persist(p);


        Cliente bd = entityManager.find(Cliente.class,12);
        Assert.assertFalse(bd.getPedidos().isEmpty());
    }

    @Test
    public void determinarMetodoDePagamentoCartao(){

        Pedido p = entityManager.find(Pedido.class,1);

        PagamentoCartao pg = new PagamentoCartao();

        pg.setNumero("4221001359318535");
        pg.setStatus(StatusPagamentoEnum.PROCESSANDO);
        pg.setPedidoId(p);

        entityManager.persist(pg);

        Assert.assertNotNull(pg.getId());
    }

    @Test
    public void determinarMetodoGerarNotaFiscal(){

        Pedido p = entityManager.find(Pedido.class,1);

        NotaFiscal nf = new NotaFiscal();

        nf.setDataEmissao(new Date());
        nf.setXml("xml");
        nf.setPedidoId(p);

        entityManager.persist(nf);

        Assert.assertNotNull(nf.getId());
    }


}
