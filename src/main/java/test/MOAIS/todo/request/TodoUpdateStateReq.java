package test.MOAIS.todo.request;

import lombok.Getter;
import test.MOAIS.todo.TodoState;

@Getter
public class TodoUpdateStateReq {
    private TodoState state;
}
