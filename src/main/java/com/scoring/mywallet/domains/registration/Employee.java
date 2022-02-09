package com.scoring.mywallet.domains.registration;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@FieldNameConstants
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Employee implements UserDetails {

    @Id
    @Column(name = "employee_id", unique = true)
    private UUID id = UUID.randomUUID();

    @Column(name = "email", unique = true)
    @NotEmpty(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Password cannot be null")
    private String password;

    @Column(name = "username", unique = true)
    @NotEmpty(message = "Username cannot be null")
    private String username;

    @Column(name = "firstname")
    @NotEmpty(message = "FirstName cannot be null")
    private String firstName;

    @Column(name = "lastname")
    @NotEmpty(message = "LastName cannot be null")
    private String lastName;

    @Transient
    private List<Authority.Roles> userRole;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "employee_id")
    private List<Authority> authorities = new ArrayList<>() {
        {
            add(new Authority());
        }
    };

    public Employee(String email, String password, String username, String firstName, String lastName, List<Authority> authorities) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
