package com.ServiceSwap.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id",updatable = false)
    private Integer id;
    @Column(name = "first_name",length = 20,nullable = false,columnDefinition = "VARCHAR(20) ")
    private String firstName;
    @Column(name = "last_name",length = 20,nullable = false,columnDefinition = "VARCHAR(20) ")
    private String  lastName;
    @Column(name = "password",unique = true,nullable = false)
    private String password;
    @Column(name = "email",unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false,updatable = false)
    private Role role;

    //customer
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Customer customer;
    //seller
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Seller seller;
    //admin
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Admin admin;




    ///methods

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email ;
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
