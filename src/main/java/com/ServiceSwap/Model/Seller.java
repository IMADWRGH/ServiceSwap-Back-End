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
@Table(name = "seller")
public class Seller extends User{
    @Column(name = "service_id",length = 20,nullable = false,columnDefinition = "VARCHAR(20) ")
    private Integer serviceId;

    //////relation//////////
    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    private List<Reviews> reviews;
    ///////////
    @OneToOne(mappedBy = "seller",cascade = CascadeType.ALL)
    private Service service;


}
