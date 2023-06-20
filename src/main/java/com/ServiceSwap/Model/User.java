package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private Integer id;
    @Column(name = "password",unique = true,nullable = false)
    private String password;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "status",nullable = false,updatable = false)
    private String status;
    @Column(name = "role",nullable = false,updatable = false)
    private String role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Seller seller;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Customer customer;
}
