package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id",updatable = false)
    private Integer id;
    @Column(name = "password",unique = true,nullable = false)
    private String password;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "status",nullable = false,updatable = false)
    private String status;
    @Column(name = "role",nullable = false,updatable = false)
    private Role role;


    @OneToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;


    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
