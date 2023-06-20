package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",updatable = false)
    private Integer userId;
    @Column(name = "first_name",length = 20,nullable = false,columnDefinition = "VARCHAR(20) ")
    private String firstName;
    @Column(name = "last_name",length = 20,nullable = false,columnDefinition = "VARCHAR(20) ")
    private String  lastName;
    @Column(name = "address",length = 50,nullable = false,columnDefinition = "VARCHAR(50) ")
    private String address;
    @Column(name = "ville",length = 25,nullable = false,columnDefinition = "VARCHAR(25) ")
    private String Ville;
    @Column(name = "nbr_phone",length = 12,nullable = false,columnDefinition = "VARCHAR(12) ")
    private String phone;
    @Column(name = "sexe",length = 20,nullable = false,columnDefinition = "VARCHAR(20) ")
    private String sexe;
    @Column(name = "nbr_order",length = 20,nullable = false,columnDefinition = "VARCHAR(20) ")
    private Integer nbrOrder;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
