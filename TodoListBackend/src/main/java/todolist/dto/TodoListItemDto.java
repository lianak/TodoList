package todolist.dto;

/**
 * @author liana
 */

public class TodoListItemDto {

    private Integer id;
    private String title;
    private boolean isCompleted;

    public TodoListItemDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
