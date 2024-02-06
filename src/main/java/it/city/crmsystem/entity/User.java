package it.city.crmsystem.entity;

import it.city.crmsystem.entity.enums.Gender;
import it.city.crmsystem.entity.template.AbsEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends AbsEntity implements UserDetails {

    private String fullName;
    private String birthDate;
    private String phoneNumber;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Email(regexp=".*@.*\\..*", message = "Email should be valid")
    private String email;

    @OneToOne
    private Attachment attachment;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;//USERNING ROLELARI

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_permission",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
//    private Set<Permission> permissions;//USERNING HUQUQLARI



    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialNonExpired = true;
    private boolean enabled;


        @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authority = new HashSet<>();
//        for (Permission permission : permissions) {
//            authority.add(new SimpleGrantedAuthority(permission.getPermissionName().name()));
//        }
//        for (Role role : roles) {
//           authority.add(new SimpleGrantedAuthority(role.getRoleName().name()));
//        }
//        return authority;
            return null;
    }
    @Override
    public String getUsername() {
        return this.getPhoneNumber();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialNonExpired();
    }
}
