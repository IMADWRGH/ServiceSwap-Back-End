package com.ServiceSwap.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Admin {
    @Id
    @Column(name = "admin_id",updatable = false)
    private Integer id;
    @Column(name = "Admin_name")
    private String name;
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
}
