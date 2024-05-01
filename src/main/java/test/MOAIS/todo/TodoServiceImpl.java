package test.MOAIS.todo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import test.MOAIS.common.exception.CustomException;
import test.MOAIS.todo.dto.TodoInterface;
import test.MOAIS.todo.request.TodoRegisReq;
import test.MOAIS.todo.request.TodoUpdateStateReq;
import test.MOAIS.user.UserRepository;
import test.MOAIS.user.Users;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Todo regis(TodoRegisReq todoRegisReq) {

        Users user = userRepository.findById(todoRegisReq.getUserId()).orElseThrow(() -> new CustomException("user not found", HttpStatus.BAD_REQUEST));

        Todo todo = Todo.builder()
                .user(user)
                .proceedDate(todoRegisReq.getProceedDate())
                .content(todoRegisReq.getContent())
                .state(todoRegisReq.getState())
                .build();

        todoRepository.save(todo);

        return todo;
    }

    @Override
    @Transactional
    public TodoInterface getRecentOne() {
        return todoRepository.findRecentTodo(LocalDate.now());
    }

    @Override
    @Transactional
    public List<TodoInterface> getSearchAll(int pageNumber, Long userId) {
        PageRequest pageRequest = PageRequest.of(pageNumber, 10);
        Page<TodoInterface> todoInterfacePage = todoRepository.findByUserId(userId, pageRequest);
        return todoInterfacePage.getContent();
    }

    @Override
    @Transactional
    public int updateState(TodoUpdateStateReq todoUpdateStateReq, Long todoId) throws CustomException{
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new CustomException("존재하지 않는 Todo 입니다.", HttpStatus.NO_CONTENT));
        int updateCnt = 0;
        if(todoUpdateStateReq.getState().equals(TodoState.Hold)){
            if(todo.getState().equals(TodoState.Proceed)) updateCnt = todoRepository.updateTodoState(todoId, todoUpdateStateReq.getState());
        }else{
            updateCnt = todoRepository.updateTodoState(todoId, todoUpdateStateReq.getState());
        }

        return updateCnt;
    }
}
