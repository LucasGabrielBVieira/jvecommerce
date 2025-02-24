package com.lcsoftware.jvcommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="tb_order")
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class OrderDomain {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="client_id")
    @Getter
    private UserDomain client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @Getter
    private PaymentDomain payment;

    @Getter
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItemDomain> items = new HashSet<>();

    public List<ProductDomain> getProducts() {
        return items.stream().map(OrderItemDomain::getProduct).collect(Collectors.toList());
    }
}
