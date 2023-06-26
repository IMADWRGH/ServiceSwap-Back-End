package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "panel")
public class Panel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "panel_id")
    private Integer panelId;


    ////relationship
    //customer
    @OneToOne(mappedBy = "panel")
    private Customer customer;
    // service
    @OneToMany(mappedBy = "panel")
    private List<Service> services;

}
