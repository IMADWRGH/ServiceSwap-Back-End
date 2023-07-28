package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


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
    @Column(name = "name_service",nullable = false)
    private String nameService;
    @Column(name = " description",columnDefinition = "Text ")
    private String  description;
    @Lob
    @Column(name = "image",nullable = false,length = Integer.MAX_VALUE)
    private byte[] imgService;
    @Column(name = "price_service",nullable = false)
    private double priceService;
    @Column(name = "type_service")
    private String type;
    @Column(name = "status")
    private boolean status;
    @Column(name = "created_at")
    @CreationTimestamp
    private Date dataCreate;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date dataUpdate;


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
