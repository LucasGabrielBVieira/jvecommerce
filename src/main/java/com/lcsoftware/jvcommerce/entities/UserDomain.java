package com.lcsoftware.jvcommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    private LocalDate birthDate;

    private String password;

    @OneToMany(mappedBy = "client")
    private List<OrderDomain> orders = new ArrayList<>();
}
