package com.lcsoftware.jvcommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@EntityScan
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDomain {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;
}
