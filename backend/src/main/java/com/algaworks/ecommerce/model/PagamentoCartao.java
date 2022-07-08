package com.algaworks.ecommerce.model;

import com.algaworks.ecommerce.model.classesabstratas.Pagamento;
import com.algaworks.ecommerce.model.classespadrao.EntidadeBaseInteger;
import com.algaworks.ecommerce.model.enums.StatusPagamento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@DiscriminatorValue("cartao")
@Entity
//@Table(name = "pagamento_cartao")
public class PagamentoCartao extends Pagamento {

    @Column(name = "numero_cartao")
    private String numeroCartao;
}
