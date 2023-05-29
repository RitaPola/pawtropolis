package com.project.pawtropoliss.game;

import com.project.pawtropoliss.command.model.ParameterCommand;
import com.project.pawtropoliss.command.TypeCommand;
import com.project.pawtropoliss.command.model.*;
import com.project.pawtropoliss.game.input.InputController;
import com.project.pawtropoliss.map.MapController;
import com.project.pawtropoliss.player.model.Player;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class GameController {
    private CommandFactory commandFactory;
    private MapController mapController;
    private Player player;
    private boolean wantQuit;

    @Autowired
    public GameController(CommandFactory commandFactory , MapController mapController , Player player) {
        this.commandFactory = commandFactory;
        this.mapController = mapController;
        this.player = player;
        this.wantQuit = false;
    }

    public void quitGame() {
        wantQuit = true;
    }

    public void playGame() {
        System.out.println ("\n " +getMapController().look() );
        do {
            String input = InputController.getInputString("> ");
            String[] parts = input.split(" ", 2);
            String commandName = parts[0];
            String parameter = parts.length > 1 ? parts[1] : null;
            ParameterCommand.setParameter(parameter);
            TypeCommand typeCommand = TypeCommand.type(commandName);
            Command command = commandFactory.commandAction(typeCommand);
            if (command != null) {
                command.execute();
            }
        } while (!wantQuit);
    }
}


