package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
