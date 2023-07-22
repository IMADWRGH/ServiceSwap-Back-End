package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements UserDetails {
    @Id
    @Column(name = "customer_id",updatable = false)
    private Integer id;
    @Lob
    @Column(name = "image",nullable = false,length = Integer.MAX_VALUE)
    private byte[] img;
    @Column(name = "address",length = 50,nullable = false,columnDefinition = "VARCHAR(50) ")
    private String address;
    @Column(name = "ville",length = 25,nullable = false,columnDefinition = "VARCHAR(25) ")
    private String Ville;
    @Column(name = "nbr_phone",length = 12,nullable = false,columnDefinition = "VARCHAR(12) ")
    private String phone;
    @Column(name = "sexe",length = 4,nullable = false,columnDefinition = "VARCHAR(4) ")
    private String sexe;
    @Column(name = "created_at")
    @CreationTimestamp
    private Date dataCreate;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date dataUpdate;
    /////relationship/////
    //user
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
    //reviews
   @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
   private List<Reviews> reviews;

   //panel
   @OneToOne
   @JoinColumn(name = "panel_id")
    private Panel panel;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
