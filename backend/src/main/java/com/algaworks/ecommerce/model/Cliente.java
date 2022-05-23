package com.algaworks.ecommerce.model;

import com.algaworks.ecommerce.model.enums.SexoCliente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private SexoCliente sexoCliente;
}