package com.scoring.mywallet.domains.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

    @Id
    @Column(name = "authorities_id")
    private UUID id = UUID.randomUUID();

    @Column(name = "authority")
    @Enumerated(EnumType.STRING)
    private Roles authority = Roles.user;

    public String getAuthority() {
        return authority.name();
    }

    public Authority(Roles authority) {
        this.authority = authority;
    }

    public enum Roles {
        admin,
        user
    }


}
