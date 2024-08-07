package test.MOAIS.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import test.MOAIS.auth.Authority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("유저 넘버")
    @Column(name = "id")
    private Long id;

    @Comment("유저 계정 아이디")
    private String userId;

    @Comment("유저 닉네임")
    private String nickname;

    @Comment("유저 비밀번호")
    private String password;

    @Comment("유저 탈퇴 여부 F=0, T=1")
    @ColumnDefault("0")
    @Setter
    private boolean deleted;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthorityName()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return this.userId;
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

    //== 패스워드 암호화 ==//
//    public void encodePassword(PasswordEncoder passwordEncoder){
//        this.password = passwordEncoder.encode(password);
//    }
}
