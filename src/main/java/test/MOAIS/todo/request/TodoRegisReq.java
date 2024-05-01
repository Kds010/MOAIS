package test.MOAIS.todo.request;

import lombok.Getter;
import test.MOAIS.todo.TodoState;

import java.time.LocalDate;

@Getter
public class TodoRegisReq {
    private String content;
    private TodoState state;
    private LocalDate proceedDate;
    private Long userId; // TODO jwt 기능 후 jwt에서 추출해 사용.
}
