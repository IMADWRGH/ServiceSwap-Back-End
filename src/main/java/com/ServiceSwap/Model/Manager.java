package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "magager")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name",length = 50,nullable = false,columnDefinition = "VARCHAR(50) ")
    private String fullname;


    ////////////relation/////////

}
