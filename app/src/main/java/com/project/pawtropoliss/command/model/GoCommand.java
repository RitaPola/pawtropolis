package com.project.pawtropoliss.command.model;

import com.project.pawtropoliss.game.GameController;
import com.project.pawtropoliss.map.model.Direction;
import com.project.pawtropoliss.map.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GoCommand extends Command {

    @Autowired
    public GoCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        String directionInput = ParameterCommand.getParameter();
        Direction direction;
        try {
            direction = Direction.valueOf(directionInput.toUpperCase());
            System.out.println ( "Welcome to room at " + direction);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid direction. Please enter a valid direction (NORTH, SOUTH, EAST, WEST).");
            return;
        }

        boolean isRoomChanged = getGameController().getMapController().changeRoom(direction);
        if (isRoomChanged) {
            System.out.println(getGameController().getMapController().look());
        } else {
            System.out.println("There's no room in that direction.\n");
        }
    }
}
