package com.algaworks.ecommerce.operacoesemcascata;


import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.ItemPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;
import com.algaworks.ecommerce.model.chavecomposta.ItemPedidoId;
import org.junit.Assert;

public class CascadeTypeRemoveTest extends EntityManagerTest {

    //@Test
    public void removerRelacaoProdutoCategoria() {
        Produto produto = entityManager.find(Produto.class, 1);
        Assert.assertFalse(produto.getCategorias().isEmpty());

        entityManager.getTransaction().begin();
        produto.getCategorias().clear();
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertTrue(produtoVerificacao.getCategorias().isEmpty());
    }

    // @Test
    public void removerPedidoEItens() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(pedido); // Necessário CascadeType.REMOVE no atributo "itens".
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNull(pedidoVerificacao);
    }

    // @Test
    public void removerItemPedidoEPedido() {
        ItemPedido itemPedido = entityManager.find(
                ItemPedido.class, new ItemPedidoId(1, 1));

        entityManager.getTransaction().begin();
        entityManager.remove(itemPedido); // Necessário CascadeType.REMOVE no atributo "pedido".
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, itemPedido.getPedido().getId());
        Assert.assertNull(pedidoVerificacao);
    }
}
