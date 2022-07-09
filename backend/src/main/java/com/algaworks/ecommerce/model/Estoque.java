package com.algaworks.ecommerce.model;

import com.algaworks.ecommerce.model.classespadrao.EntidadeBaseInteger;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "estoque")
public class Estoque extends EntidadeBaseInteger {

    @OneToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(columnDefinition = "int(11) not null")
    private Integer quantidade;
}
