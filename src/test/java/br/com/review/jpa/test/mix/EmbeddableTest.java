package br.com.review.jpa.test.mix;

import br.com.jpa.review.model.EnderecoEntregaPedido;
import br.com.jpa.review.model.Pedido;
import br.com.jpa.review.model.StatusPedidosEnum;
import br.com.review.jpa.test.manager.EntityManagerGeneric;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.time.LocalDateTime;

public class EmbeddableTest extends EntityManagerGeneric {

    @Test
    public void isnerirComEmbeddable(){
        EnderecoEntregaPedido end = new EnderecoEntregaPedido();
        end.setBairro("pajuçara");
        end.setCep("61932230");
        end.setCidade("maracaneú");
        end.setComplemento("a");
        end.setNumero("284");
        end.setLogradouro("joaquim ferreira de sousa");


        Pedido p = new Pedido();
        p.setDataPedido(LocalDateTime.now());
        p.setStatus(StatusPedidosEnum.PAGO);
        p.setEnderecoEntregaPedido(end);

        Pedido pedido = entityManager.merge(p);
        Assert.assertNotNull(pedido.getId());

    }

}
