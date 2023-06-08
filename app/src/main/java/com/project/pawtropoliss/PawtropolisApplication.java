
package com.project.pawtropoliss;
import com.project.pawtropoliss.game.GameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PawtropolisApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PawtropolisApplication.class, args);
        context.getBean(GameController.class).playGame();
    }
}
