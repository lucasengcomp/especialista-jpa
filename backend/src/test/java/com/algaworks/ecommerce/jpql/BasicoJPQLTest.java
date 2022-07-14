package com.algaworks.ecommerce.jpql;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.dto.ProdutoDTO;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class BasicoJPQLTest extends EntityManagerTest {

    @Test
    public void ordenarResultado() {
        String jpql = "SELECT c FROM Cliente c " +
                "ORDER BY c.nome";

        TypedQuery<Cliente> typedQuery = entityManager.createQuery(jpql, Cliente.class);
        List<Cliente> lista = typedQuery.getResultList();

        Assert.assertFalse(lista.isEmpty());
        lista.forEach(p -> System.out.println(p.getId() + ", " + p.getNome()));
    }

    @Test
    public void projetoNoDTO() {
        String jpql = "SELECT new com.algaworks.ecommerce.dto.ProdutoDTO(id, nome) FROM Produto";

        TypedQuery<ProdutoDTO> typedQuery = entityManager.createQuery(jpql, ProdutoDTO.class);
        List<ProdutoDTO> lista = typedQuery.getResultList();

        Assert.assertFalse(lista.isEmpty());
        lista.forEach(p -> System.out.println(p.getId() + ", " + p.getNome()));
    }

    @Test
    public void projetarOResultado() {
        String jpql = "SELECT id, nome FROM Produto";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> lista = typedQuery.getResultList();

        Assert.assertTrue(lista.get(0).length == 2);
        lista.forEach(array -> System.out.println(array[0] + ", " + array[1]));
    }

    @Test
    public void selecionarUmAtributoParaRetorno() {
        String jpql = "SELECT p.nome FROM Produto p";

        TypedQuery<String> typedQuery = entityManager.createQuery(jpql, String.class);
        List<String> listaDeProdutos = typedQuery.getResultList();
        Assert.assertTrue(String.class.equals(listaDeProdutos.get(0).getClass()));

        String jpqlCliente = "SELECT p.cliente FROM Pedido p";
        TypedQuery<Cliente> typedQueryCliente = entityManager.createQuery(jpqlCliente, Cliente.class);
        List<Cliente> listaDeClientes = typedQueryCliente.getResultList();

        Assert.assertTrue(Cliente.class.equals(listaDeClientes.get(0).getClass()));
    }

    @Test
    public void buscarPorIdentificador() {
        TypedQuery<Pedido> typedQuery = entityManager
                .createQuery("SELECT p FROM Pedido p WHERE p.id = 1", Pedido.class);

        Pedido pedido = typedQuery.getSingleResult();
        Assert.assertNotNull(pedido);
    }

    @Test
    public void mostrarDiferencaQueries() {
        String jpql = "SELECT p FROM Pedido p WHERE p.id = 1";
        TypedQuery<Pedido> typedQuery = entityManager.createQuery(jpql, Pedido.class);

        Pedido pedido1 = typedQuery.getSingleResult();
        Assert.assertNotNull(pedido1);

        Query query = entityManager.createQuery(jpql);
        Pedido pedido2 = (Pedido) query.getSingleResult();

        Assert.assertNotNull(pedido2);
    }
}
