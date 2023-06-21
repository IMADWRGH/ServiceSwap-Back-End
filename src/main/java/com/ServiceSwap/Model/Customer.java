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
@Table(name = "customer")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id")
    @SequenceGenerator(initialValue = 1, name = "customer_id", sequenceName = "customer_sequence")
    @Column(name = "customer_id",updatable = false)
    private Integer customerId;
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
   @OneToMany(mappedBy = "review_customer",cascade = CascadeType.ALL)
   @JsonIgnore
   private List<Reviews> reviewsList;
}
