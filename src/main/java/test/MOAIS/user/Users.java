package test.MOAIS.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import test.MOAIS.auth.Authority;

import java.util.Set;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("유저 넘버")
    @Column(name = "id")
    private Long id;

    @Comment("유저 계정 아이디")
    private String userId;

    @Comment("유저 닉네임")
    @Column(unique = true)
    private String nickname;

    @Comment("유저 비밀번호")
    private String password;

//    @ManyToMany
//    @JoinTable(
//            name = "user_authority",
//            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
//    private Set<Authority> authorities;

    //== 패스워드 암호화 ==//
//    public void encodePassword(PasswordEncoder passwordEncoder){
//        this.password = passwordEncoder.encode(password);
//    }
}
