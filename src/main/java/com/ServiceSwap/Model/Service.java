package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_id",updatable = false)
    private Integer serviceId;
    @Column(name = " description ",columnDefinition = "Text ")
    private String  description;
    @Lob
    @Column(name = "image",nullable = false,length = Integer.MAX_VALUE)
    private byte[] imgService;
    @Column(name = "name_service",nullable = false)
    private String nameService;
    @Column(name = "price_service",nullable = false)
    private double priceService;


    ////relationship
    //seller
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    //panel
    @ManyToOne
    @JoinColumn(name = "panel_id")
    private Panel panel;
    //reviews
    @ManyToOne
    @JoinColumn(name = "review_id")
    private  Reviews reviews;
}
