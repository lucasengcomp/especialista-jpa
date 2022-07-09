package com.algaworks.ecommerce.model;

import com.algaworks.ecommerce.model.classesabstratas.Pagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@DiscriminatorValue("boleto")
@Entity
//@Table(name = "pagamento_boleto")
public class PagamentoBoleto extends Pagamento {

    @Column(name = "codigo_barras", length = 100, nullable = false)
    private String codigoBarras;
}
