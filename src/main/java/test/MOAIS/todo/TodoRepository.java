package test.MOAIS.todo;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.MOAIS.todo.dto.TodoInterface;

import java.time.LocalDate;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query(value = "SELECT id, user_id as userId, state, content, proceed_date as proceedDate from Todo where proceed_date >= :now order by proceed_date asc limit 1", nativeQuery = true)
    TodoInterface findRecentTodo(@Param("now") LocalDate now);

    Page<TodoInterface> findByUserId(Long userId, Pageable pageable);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Todo SET state = :State WHERE id = :todoId", nativeQuery = true)
    int updateTodoState(@Param("todoId") Long todoId, @Param("State") TodoState todoState);
}
