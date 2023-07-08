package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id",updatable = false)
    private Integer id;
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
    /////relationship/////
    //user
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
    //reviews
   @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
   private List<Reviews> reviews;

   //panel
   @OneToOne
   @JoinColumn(name = "panel_id")
    private Panel panel;

}
