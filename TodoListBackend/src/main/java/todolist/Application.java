package todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author liana
 */
@ImportResource("/application-context.xml")
@SpringBootApplication
@ComponentScan(basePackages = "todolist")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
