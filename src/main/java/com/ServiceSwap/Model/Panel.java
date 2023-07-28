package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
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
    @Column(name = "created_at")
    @CreationTimestamp
    private Date dataCreate;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date dataUpdate;

    ////relationship
    //customer
    @OneToOne(mappedBy = "panel")
    private Customer customer;
    // service
    @OneToMany(mappedBy = "panel")
    private List<Service> services;

}
