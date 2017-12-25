package todolist.controller;

import todolist.dto.TodoListItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todolist.service.TodoListService;

import java.util.List;

/**
 * @author liana
 */

@RestController
@RequestMapping(value = "/todolistitem", produces = "application/json")
@CrossOrigin
public final class TodoListController {

    private final TodoListService todoListService;

    @Autowired
    TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping("/all")
    @ResponseBody
    List<TodoListItemDto> getAll() {
        return todoListService.getAll();
    }

    @GetMapping("/completed")
    @ResponseBody
    List<TodoListItemDto> getCompleted() {
        return todoListService.getCompleted();
    }

    @GetMapping("/uncompleted")
    @ResponseBody
    List<TodoListItemDto> getUnCompleted() {
        return todoListService.getUnCompleted();
    }

    @PostMapping(consumes = "application/json")
    TodoListItemDto create(@RequestBody TodoListItemDto dto) {
        return todoListService.create(dto);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    Integer update(@RequestBody TodoListItemDto dto,
                   @PathVariable String id) {
        Integer idLong = Integer.valueOf(id);
        dto.setId(idLong);
        return todoListService.update(dto);
    }
}


