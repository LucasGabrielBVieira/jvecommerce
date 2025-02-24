package com.lcsoftware.jvcommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order_item")
@NoArgsConstructor
public class OrderItemDomain {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private Double price;

    public OrderItemDomain(OrderDomain order, ProductDomain product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDomain getOrder() {
        return id.getOrder();
    }

    public void setOrder(OrderDomain order) {
        id.setOrder(order);
    }

    public ProductDomain getProduct() {
        return id.getProduct();
    }

    public void setProduct(ProductDomain product) {
        id.setProduct(product);
    }
}
