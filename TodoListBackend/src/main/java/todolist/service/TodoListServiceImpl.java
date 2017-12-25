package todolist.service;

import todolist.dto.TodoListItemDto;
import todolist.dto.TodoListItemMapper;
import todolist.model.TodoListItem;
import todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liana
 */

@Service
public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepository repository;

    @Autowired
    public TodoListServiceImpl(@NotNull TodoListRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TodoListItemDto> getAll() {
        return TodoListItemMapper.mapEntitiesIntoDto(repository.findAll());
    }

    @Override
    public List<TodoListItemDto> getCompleted() {
        return TodoListItemMapper.mapEntitiesIntoDto(repository.findByIsCompleted(true));
    }

    @Override
    public List<TodoListItemDto> getUnCompleted() {
        return TodoListItemMapper.mapEntitiesIntoDto((repository.findByIsCompleted(false)));
    }

    @Override
    public TodoListItemDto create(TodoListItemDto dto) {
        TodoListItem created = TodoListItem.getBuilder()
                .title(dto.getTitle())
                .done(dto.isCompleted())
                .build();
        return TodoListItemMapper.mapEntityIntoDto(repository.save(created));
    }

    @Override
    public Integer update(@NotNull TodoListItemDto dto) {
        return repository.updateById(dto.isCompleted(),
                dto.getTitle(),
                dto.getId());
    }
}
