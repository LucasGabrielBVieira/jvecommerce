package com.lcsoftware.jvcommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Classe auxiliar para chave primária composta
@Embeddable
public class OrderItemPK {

    @ManyToOne
    @JoinColumn
    private OrderDomain order;

    @ManyToOne
    @JoinColumn
    private ProductDomain product;

}
