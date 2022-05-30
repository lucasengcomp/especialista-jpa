package com.algaworks.ecommerce.mapeamentobasico;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.embededs.EnderecoEntregaPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutido extends EntityManagerTest {

    @Test
    public void analisarMapeamentoObjetoEmbutido() {
        EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
        endereco.setCep("123456");
        endereco.setLogradouro("Rua das laranjeiras");
        endereco.setBairro("Centro");
        endereco.setNumero("123A");
        endereco.setCidade("Anápolis");
        endereco.setEstado("Goiás");

        Pedido pedido = new Pedido();
//        pedido.setId(1);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(new BigDecimal(1000));

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao);
        Assert.assertNotNull(pedidoVerificacao.getId());
        Assert.assertNotNull(pedidoVerificacao.getEndereco().getCep());
    }
}
