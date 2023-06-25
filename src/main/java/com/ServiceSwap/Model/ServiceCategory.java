package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Table(name = "service_category")
public class ServiceCategory {
    @Id
    @GeneratedValue
    @Column(name = "category_id",updatable = false)
    private  Integer categoryId;
    private String nameCategory;
    private String description;
    @Column(name = "created_at")
    @CreationTimestamp
    private Date dataCreate;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date dataUpdate;


}
