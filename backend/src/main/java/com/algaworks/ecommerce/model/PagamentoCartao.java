package com.algaworks.ecommerce.model;

import com.algaworks.ecommerce.model.classesabstratas.Pagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@DiscriminatorValue("cartao")
@Entity
//@Table(name = "pagamento_cartao")
public class PagamentoCartao extends Pagamento {

    @Column(name = "numero_cartao", length = 50, nullable = false)
    private String numeroCartao;
}
