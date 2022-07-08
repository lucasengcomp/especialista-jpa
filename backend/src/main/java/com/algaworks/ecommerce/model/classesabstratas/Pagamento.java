package com.algaworks.ecommerce.model.classesabstratas;

import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.classespadrao.EntidadeBaseInteger;
import com.algaworks.ecommerce.model.enums.StatusPagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pagamento_boleto")
public abstract class Pagamento extends EntidadeBaseInteger {

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;
}
