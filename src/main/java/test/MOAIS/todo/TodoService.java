package test.MOAIS.todo;

import test.MOAIS.todo.dto.TodoInterface;
import test.MOAIS.todo.request.TodoRegisReq;
import test.MOAIS.todo.request.TodoUpdateStateReq;

import java.util.List;

public interface TodoService {
    Todo regis(TodoRegisReq todoRegisReq);
    TodoInterface getRecentOne();
    List<TodoInterface> getSearchAll(int pageNumber, Long userId);
    int updateState(TodoUpdateStateReq todoUpdateStateReq, Long todoId);
}
