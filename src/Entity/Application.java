package Entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext
                ("spring-config.xml");
        System.out.println("Let's inspect the beans provided by Spring Boot:");

    }

}