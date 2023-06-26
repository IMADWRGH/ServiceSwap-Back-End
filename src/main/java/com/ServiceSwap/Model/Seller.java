package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seller")
public class Seller{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seller_id",updatable = false)
    private Integer id;
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
    @Column(name = "created_at")
    @CreationTimestamp
    private Date dataCreate;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date dataUpdate;
    @Column(name = "service_id",length = 20,nullable = false,columnDefinition = "VARCHAR(20) ")
    private Integer serviceId;

    //////relation//////////
    //user
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
    //service
    @OneToOne(mappedBy = "seller",cascade = CascadeType.ALL)
    private Service service;


}
