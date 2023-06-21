package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seller")
public class Seller{
    @Id
    @GeneratedValue
    @Column(name = "seller_id",updatable = false)
    private Integer sellerId;
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
    @Column(name = "service_id",length = 20,nullable = false,columnDefinition = "VARCHAR(20) ")
    private Integer serviceId;

    //////relation//////////
    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    private List<Reviews> reviews;
    ///////////
    @OneToOne(mappedBy = "seller",cascade = CascadeType.ALL)
    private Service service;


}
