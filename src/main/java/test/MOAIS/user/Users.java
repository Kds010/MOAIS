package test.MOAIS.user;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("유저 넘버")
    private Long id;

    @Comment("유저 계정 아이디")
    private String userId;

    @Comment("유저 닉네임")
    private String nickName;

    @Comment("유저 비밀번호")
    private String passWord;
}
