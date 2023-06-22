package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends User{
    @Column(name = "nbr_order",length = 20,nullable = false,columnDefinition = "VARCHAR(20) ")
    private Integer nbrOrder;

    /////relationship/////
   @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
   private List<Reviews> reviews;

   @OneToOne
   @JoinColumn(name = "panel_id")
    private Panel panel;
}
