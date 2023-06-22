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
    @GeneratedValue
    @Column(name = "panel_id")
    private Integer panelId;


    ////relationship
    @OneToOne(mappedBy = "panel")
    private Customer customer;
    ////
    @OneToMany(mappedBy = "")
    @JoinColumn(name = "service_id")
    private List<Service> services;

}
