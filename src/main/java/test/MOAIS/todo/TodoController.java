package test.MOAIS.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.MOAIS.common.exception.CustomException;
import test.MOAIS.todo.dto.TodoInterface;
import test.MOAIS.todo.request.TodoRegisReq;
import test.MOAIS.todo.request.TodoUpdateStateReq;
import test.MOAIS.user.request.UserSingUpReq;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @ResponseBody
    @PostMapping("")
    public ResponseEntity<Todo> regis(@RequestBody TodoRegisReq todoRegisReq) {
        Todo todo = todoService.regis(todoRegisReq);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/recent")
    public ResponseEntity<TodoInterface> getRecentOne() {
        TodoInterface todoInterface = todoService.getRecentOne();
        return new ResponseEntity<>(todoInterface, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("")
    public ResponseEntity<List<TodoInterface>> getSearchAll(@RequestParam int pageNumber,
                                                            @RequestParam Long userId) {
        List<TodoInterface> todoInterfaceList = todoService.getSearchAll(pageNumber, userId);
        return new ResponseEntity<>(todoInterfaceList, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping("/{todoId}")
    public ResponseEntity<String> updateState(@RequestBody TodoUpdateStateReq todoUpdateStateReq,
                                              @PathVariable Long todoId) {
        try{
            if(todoService.updateState(todoUpdateStateReq, todoId) > 0){
                return ResponseEntity.status(HttpStatus.OK).body(todoUpdateStateReq.getState()+"로 상태가 변경되었습니다.");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body("Proceed 상태가 아닙니다.");
            }
        }catch (CustomException e){
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
    }
}
