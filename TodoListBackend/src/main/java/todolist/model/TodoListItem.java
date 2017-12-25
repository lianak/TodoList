package todolist.model;

import javax.persistence.*;

/**
 * @author liana
 */

@Entity
@Table(name = "todolistitem")
public class TodoListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "completed", nullable = false)
    private boolean isCompleted;


    public TodoListItem() {
    }


    private TodoListItem(Builder builder) {
        this.title = builder.title;
        this.isCompleted = builder.isDone;
    }

    public static Builder getBuilder() {
        return new Builder();
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TodoListItem)) {
            return false;
        }
        TodoListItem other = (TodoListItem) object;
        return other.getId().equals(this.id)
                && other.getTitle().equals(this.title)
                && other.isCompleted() == this.isCompleted;
    }

    @Override
    public int hashCode() {
        return 11 * title.hashCode() + id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("id: %d, title: %s, completed: %b",
                this.id,
                this.title,
                this.isCompleted);
    }

    public static class Builder {
        private boolean isDone;
        private String title;

        private Builder() {
        }

        public Builder done(boolean isDone) {
            this.isDone = isDone;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public TodoListItem build() {
            return new TodoListItem(this);
        }
    }


}
