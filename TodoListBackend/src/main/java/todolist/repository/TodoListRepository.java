package todolist.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import todolist.model.TodoListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author liana
 */

public interface TodoListRepository extends JpaRepository<TodoListItem, Long> {

    @Transactional
    @Query("SELECT t " +
            "FROM TodoListItem t " +
            " WHERE t.isCompleted = :isCompleted")
    List<TodoListItem> findByIsCompleted(@Param("isCompleted") boolean isCompleted);


    @Transactional
    @Modifying
    @Query("UPDATE TodoListItem t" +
            "  SET t.title = :title," +
            "t.isCompleted = :isCompleted" +
            "  WHERE t.id =:id")
    Integer updateById(@Param("isCompleted") boolean isCompleted,
                       @Param("title") String title,
                       @Param("id") Integer id);

}
