package com.algaworks.ecommerce.model.embededs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class EnderecoEntregaPedido {

    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
}
