package com.project.pawtropoliss.command.model;

import com.project.pawtropoliss.game.GameController;
import com.project.pawtropoliss.map.model.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GoCommand extends Command {

    @Autowired
    public GoCommand(GameController gameController) {
        super ( gameController );
    }

    @Override
    public void execute() {
        String directionInput = ParameterCommand.getParameter ();
        Direction direction = Direction.valueOf ( directionInput.toUpperCase () );
        if (directionInput == null || directionInput.isEmpty ()) {
            System.out.println ( "Please specify the direction where you want to go." );
            return;
        }

        try {

            boolean isRoomChanged = getGameController ().getMapController ().changeRoom ( direction );

            if (isRoomChanged) {
                System.out.println ( "Welcome to the room at " + direction );
                System.out.println ( getGameController ().getMapController ().look () );
            } else {
                System.out.println ( "There's no room in that direction." );
            }
        } catch (IllegalArgumentException e) {
            System.out.println ( "Invalid direction. Please enter a valid direction (NORTH, SOUTH, EAST, WEST)." );
        }
    }
}
