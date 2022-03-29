package uz.maniac4j.organizationservice.user;


import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.maniac4j.organizationservice.organization.Organization;
import uz.maniac4j.organizationservice.template.EntityLong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "users")
public class User extends EntityLong implements UserDetails {



    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;

    @NotNull
    @Column(unique = true)
    private String email;
    private String phone;
    @NotNull
    private String fio;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


    private String code;
    private boolean active=false;



    @ManyToMany
    @ToString.Exclude
    private Set<Organization> organizations;








    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }


    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
