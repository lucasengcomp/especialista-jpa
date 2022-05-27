package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacaoComTransacaoTest extends EntityManagerTest {

    @Test
    public void impedirOperacaoComBancoDeDados() {
        Produto produto = entityManager.find(Produto.class, 1);
        entityManager.detach(produto);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2ª Geração");
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle", produtoVerificacao.getNome());
    }

    @Test
    public void inserirObjetoComMerge() {
        Produto produto = new Produto();
//        produto.setId(2);
        produto.setNome("Microfone Rode Videmic");
        produto.setDescricao("A qualidade de som");
        produto.setPreco(new BigDecimal(1000));

        entityManager.getTransaction().begin();
        Produto produtoSalvo = entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class, produtoSalvo.getId());
        Assert.assertNotNull(produtoVerficacao);
    }

    @Test
    public void atualizarObjetoGerenciado() {
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Kindle paperwhite 2º geração");

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle paperwhite 2º geração", produtoVerficacao.getNome());
    }

    @Test
    public void mostrarDifencaPersistMerge() {
        Produto produtoPersist = new Produto();

//        produtoPersist.setId(5);
        produtoPersist.setNome("Smartphone One Plus");
        produtoPersist.setDescricao("O processador mais rápido.");
        produtoPersist.setPreco(new BigDecimal(2000));

        entityManager.getTransaction().begin();
        entityManager.persist(produtoPersist);
        produtoPersist.setNome("Smartphone Two Plus");
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacaoPersist = entityManager.find(Produto.class, produtoPersist.getId());
        Assert.assertNotNull(produtoVerificacaoPersist);

        Produto produtoMerge = new Produto();
//        produtoMerge.setId(6);
        produtoMerge.setNome("Notebook Dell");
        produtoMerge.setDescricao("O melhor da categoria.");
        produtoMerge.setPreco(new BigDecimal(2000));

        entityManager.getTransaction().begin();
        produtoMerge = entityManager.merge(produtoMerge);
        produtoMerge.setNome("Notebook Dell 2");
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacaoMerge = entityManager.find(Produto.class, produtoMerge.getId());
        Assert.assertNotNull(produtoVerificacaoMerge);
    }

    @Test
    public void atualizarObjeto() {
        Produto produto = new Produto();
//        produto.setId(1);
        produto.setNome("Kindle paperwhite");
        produto.setDescricao("Conheca o novo kindle");
        produto.setPreco(new BigDecimal(499));

        entityManager.getTransaction().begin();
        Produto produtoSalvoComMerge = entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerficacao = entityManager.find(Produto.class, produtoSalvoComMerge.getId());
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

//        produto.setId(2);
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
