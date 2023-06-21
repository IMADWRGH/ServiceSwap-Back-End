package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Reviews {
    @Id

    @Column(name = "review_id")
    private Integer reviewId;
    @Column(name = "commentaire")
    private String cmt;
    @Column(name = "notation")
    private byte notation;
    ////relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "customer_id")
    private Customer customer;
    ////
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "seller_id")
    private Seller seller;
}
