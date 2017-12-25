package todolist.dto;

import todolist.model.TodoListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liana
 */

public final class TodoListItemMapper {

    private TodoListItemMapper() {

    }

    public static List<TodoListItemDto> mapEntitiesIntoDto(Iterable<TodoListItem> entities) {
        List<TodoListItemDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(mapEntityIntoDto(e)));
        return dtos;
    }


    public static TodoListItemDto mapEntityIntoDto(TodoListItem entity) {
        TodoListItemDto dto = new TodoListItemDto();
        dto.setId(entity.getId());
        dto.setCompleted(entity.isCompleted());
        dto.setTitle(entity.getTitle());

        return dto;
    }


}
