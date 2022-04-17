package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacaoComTransacaoTest extends EntityManagerTest {

    @Test
    public void impedirOperacaocomBancoDeDados() {
        Produto produto = entityManager.find(Produto.class, 1);
        entityManager.detach(produto);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle paperwhite 2º geração");
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle paperwhite", produtoVerficacao.getNome());
    }

    @Test
    public void inserirObjetoComMerge() {
        Produto produto = new Produto();

        produto.setId(2);
        produto.setNome("Microfone Rode Videmic");
        produto.setDescricao("A qualidade de som");
        produto.setPreco(new BigDecimal(1000));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerficacao);
    }

    @Test
    public void atualizarObjetoGerenciado() {
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle paperwhite 2º geração");
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle paperwhite 2º geração", produtoVerficacao.getNome());
    }

    @Test
    public void atualizarObjeto() {
        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Kindle paperwhite");
        produto.setDescricao("Conheca o novo kindle");
        produto.setPreco(new BigDecimal(499));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerficacao);
        Assert.assertEquals("Kindle paperwhite", produtoVerficacao.getNome());
    }
    @Test
    public void removerObjeto() {
        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void inserirPrimeiroObjeto() {
        Produto produto = new Produto();

        produto.setId(2);
        produto.setNome("Camera");
        produto.setDescricao("A melhor câmera do momento");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerficacao);
    }
}
