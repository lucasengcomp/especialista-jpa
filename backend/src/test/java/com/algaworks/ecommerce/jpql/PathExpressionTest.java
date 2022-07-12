package com.algaworks.ecommerce.jpql;

import com.algaworks.ecommerce.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class PathExpressionTest extends EntityManagerTest {

    @Test
    public void usarPathExpression() {
        String jpql = "SELECT p.cliente.nome FROM Pedido p";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> lista = typedQuery.getResultList();

        Assert.assertFalse(lista.isEmpty());
    }
}
