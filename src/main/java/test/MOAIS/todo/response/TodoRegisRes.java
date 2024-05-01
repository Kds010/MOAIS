package test.MOAIS.todo.response;

import test.MOAIS.todo.Todo;
import test.MOAIS.todo.TodoState;

import java.time.LocalDate;

public class TodoRegisRes {
    private Long id;
    private Long userId;
    private TodoState state;
    private String content;
    private LocalDate proceedDate;

    public TodoRegisRes(Todo todo){
        this.id = todo.getId();
        this.userId = todo.getUser().getId();
        this.state = todo.getState();
        this.content = todo.getContent();
        this.proceedDate = todo.getProceedDate();
    }
}
