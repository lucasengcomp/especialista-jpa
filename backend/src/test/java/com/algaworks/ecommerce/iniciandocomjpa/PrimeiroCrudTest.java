package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void criarCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(2);
        cliente.setNome("Lucas Galvao");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        Cliente clientePersistido = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clientePersistido);
    }

    @Test
    public void buscarCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 1);
        Assert.assertNotNull(cliente);
    }

    @Test
    public void atualizarCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 1);
        cliente.setNome("Ana Galvao");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        Cliente clientePersistido = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertEquals("Ana Galvao", clientePersistido.getNome());
    }

    @Test
    public void deletarCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 5);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        Cliente clienteBuscado = entityManager.find(Cliente.class, 5);
        Assert.assertNull(clienteBuscado);
    }
}
