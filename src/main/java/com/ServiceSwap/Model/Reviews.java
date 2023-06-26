package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Integer reviewId;
    @Column(name = "commentaire")
    private String cmt;
    @Column(name = "notation")
    private byte notation;
    ////relationship
    //customer
    @ManyToOne
    @JoinColumn( name = "customer_id")
    private Customer customer;
    //service
    @OneToMany(mappedBy = "reviews")
    private List<Service> service;

}
