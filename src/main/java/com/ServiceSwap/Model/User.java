package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;


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
    @Column(name = "role",nullable = false,updatable = false)
    private Role role;

    //customer
    @OneToOne
    @PrimaryKeyJoinColumn
    private Customer customer;
    //seller
    @OneToOne
    @PrimaryKeyJoinColumn
    private Seller seller;




}
