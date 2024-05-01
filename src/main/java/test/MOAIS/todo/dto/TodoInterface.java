package test.MOAIS.todo.dto;

import java.time.LocalDate;

public interface TodoInterface {
    Long getId();
    Long getuserId();
    int getState();
    String getContent();
    LocalDate getProceedDate();
}
