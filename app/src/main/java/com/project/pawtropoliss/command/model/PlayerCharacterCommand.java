package com.project.pawtropoliss.command.model;
import com.project.pawtropoliss.game.GameController;
import com.project.pawtropoliss.game.input.InputController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerCharacterCommand extends Command {

    @Autowired
    public PlayerCharacterCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        String choice = InputController.getInputString("Do you want to increase (I) or decrease (D) health or change the name (N)? (I/D/N): ");
        if (choice.equalsIgnoreCase("I")) {
            int amount = InputController.getInputInt("Enter the amount to increase health: ");
            getGameController().getPlayer().increasePlayerHealth(amount);
            System.out.println("Health increased by " + amount + ". Current health: " + getGameController().getPlayer().getHealth());
        } else if (choice.equalsIgnoreCase("D")) {
            int amount = InputController.getInputInt("Enter the amount to decrease health: ");
            getGameController().getPlayer().decreasePlayerHealth(amount);
            System.out.println("Health decreased by " + amount + ". Current health: " + getGameController().getPlayer().getHealth());
        } else if (choice.equalsIgnoreCase("N")) {
            String newName =InputController.getInputString("Enter the new player name: ");
            getGameController().getPlayer().setName(newName);
            System.out.println("Player name changed to: " + getGameController().getPlayer().getName());
        } else {
            System.out.println("Invalid input. No changes made.");
        }
    }

}
