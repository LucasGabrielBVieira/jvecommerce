package com.lcsoftware.jvcommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Classe auxiliar para chave primária composta
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemPK {

    @ManyToOne
    @JoinColumn
    private OrderDomain order;

    @ManyToOne
    @JoinColumn
    private ProductDomain product;

}
