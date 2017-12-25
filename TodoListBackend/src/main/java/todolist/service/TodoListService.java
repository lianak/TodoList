package todolist.service;

import todolist.dto.TodoListItemDto;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liana
 */

public interface TodoListService {

    List<TodoListItemDto> getAll();

    List<TodoListItemDto> getCompleted();

    List<TodoListItemDto> getUnCompleted();

    TodoListItemDto create(@NotNull TodoListItemDto dto);

    Integer update(@NotNull TodoListItemDto dto);

}
