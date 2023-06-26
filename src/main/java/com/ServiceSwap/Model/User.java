package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id",updatable = false)
    private Integer id;
    @Column(name = "password",unique = true,nullable = false)
    private String password;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "status",nullable = false,updatable = false)
    private String status;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false,updatable = false)
    private Role role;

    //customer
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Customer customer;
    //seller
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Seller seller;




}
