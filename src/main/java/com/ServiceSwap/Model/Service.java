package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_id")
    @SequenceGenerator(initialValue = 1, name = "service_id", sequenceName = "service_sequence")
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
