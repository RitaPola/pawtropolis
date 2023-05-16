package com.project.pawtropoliss.game;
import com.project.pawtropoliss.command.service.*;
import com.project.pawtropoliss.game.input.InputController;
import com.project.pawtropoliss.player.domain.Bag;
import com.project.pawtropoliss.player.domain.Player;
import com.project.pawtropoliss.map.model.Direction;
import com.project.pawtropoliss.map.MapController;
import com.project.pawtropoliss.command.CommandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class GameController {

    private static GameController instance;

    private final MapController mapGame;

    private final InputController inputController;

    @Autowired
    private GameController() {
        this.mapGame = new MapController();
        this.inputController = new InputController();
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void playGame() {
        String playerName = inputController.getInputString("\n" + "Enter the player's name: ");
        Bag bagPlayer = new Bag(20);
        Player player = new Player(bagPlayer);
        Map<CommandManager, ActionStrategy> actions = new EnumMap<>(CommandManager.class);
        actions.put(CommandManager.LOOK, new LookActionStrategy(mapGame.getCurrentRoom()));
        actions.put(CommandManager.BAG, new BagActionStrategy(bagPlayer));
        actions.put(CommandManager.QUIT, new ExitGameActionStrategy());
        actions.put(CommandManager.GO, new GoActionStrategy(mapGame, null));
        actions.put(CommandManager.GET, new GetActionStrategy(null, null, null));
        actions.put(CommandManager.DROP, new DropActionStrategy(null, null, null));
        boolean playerQuit = false;
        do {
            System.out.println("What do you want to do?");
            String choice = inputController.getInputString("");
            CommandManager action = null;
            try {
                action = CommandManager.valueOf(choice.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + "Invalid choice. Please choose again.");
                continue;
            }
            ActionStrategy actionStrategy = actions.get(action);
            switch (action) {
                case LOOK -> actionStrategy = new LookActionStrategy(mapGame.getCurrentRoom());
                case BAG -> actionStrategy = new BagActionStrategy(bagPlayer);
                case QUIT -> {
                    actionStrategy = new ExitGameActionStrategy();
                    System.out.println(playerName + " ADIOS");
                }
                case GO -> {
                    Direction direction = inputController.getInputDirection("\n" + "Which direction do you want to go? (NORTH, SOUTH, EAST, WEST) ");
                    actionStrategy = new GoActionStrategy(mapGame, direction);
                }
                case GET -> {
                    String itemName = inputController.getInputItemName("\n" + "Which item do you want to get? ");
                    actionStrategy = new GetActionStrategy(itemName, player, mapGame);
                }
                case DROP -> {
                    String itemToDrop = inputController.getInputItemName("\n" + "Which item do you want to drop? ");
                    actionStrategy = new DropActionStrategy(bagPlayer, itemToDrop, mapGame);
                }
            }
            actionStrategy.execute();

        } while (!playerQuit);
    }
}
