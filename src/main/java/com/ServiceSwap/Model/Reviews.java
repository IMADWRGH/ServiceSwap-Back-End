package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
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
    @Column(name = "created_at")
    @CreationTimestamp
    private Date dataCreate;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date dataUpdate;
    ////relationship
    //customer
    @ManyToOne
    @JoinColumn( name = "customer_id")
    private Customer customer;
    //service
    @OneToMany(mappedBy = "reviews")
    private List<Service> service;

}
