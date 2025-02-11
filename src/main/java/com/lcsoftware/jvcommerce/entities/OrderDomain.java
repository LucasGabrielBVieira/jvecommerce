package com.lcsoftware.jvcommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.Order;

import java.time.Instant;

@Entity
@Table(name="tb_order")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDomain {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="client_id")
    private UserDomain client;
}
