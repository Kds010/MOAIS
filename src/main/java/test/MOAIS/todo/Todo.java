package test.MOAIS.todo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import test.MOAIS.user.Users;

import java.time.LocalDate;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Todo Id")
    @Column(name = "id")
    private Long id;

    @Comment("Todo 작성자")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    @Comment("Todo 진행 날짜")
    private LocalDate proceedDate;

    @Comment("Todo 내용")
    private String content;

    @Setter
    @Comment("Todo 상태 0=할일, 1=완료, 2=현재 진행중, 3=대기")
    private TodoState state;

}
