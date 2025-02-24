package com.lcsoftware.jvcommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.Order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="tb_product")
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductDomain {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    private String name;

    @Column(columnDefinition = "TEXT")
    @Getter
    private String description;

    @Getter
    private Double price;

    @Getter
    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryDomain> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItemDomain> items = new HashSet<>();

    public Set<OrderItemDomain> getOrdersItems() {
        return items;
    }

    public List<OrderDomain> getOrders() {
        return items.stream().map(OrderItemDomain::getOrder).collect(Collectors.toList());
    }
}
