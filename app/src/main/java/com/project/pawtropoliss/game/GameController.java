package com.project.pawtropoliss.game;

import com.project.pawtropoliss.command.service.*;
import com.project.pawtropoliss.game.input.InputController;
import com.project.pawtropoliss.player.domain.Bag;
import com.project.pawtropoliss.player.domain.Item;
import com.project.pawtropoliss.player.domain.Player;
import com.project.pawtropoliss.map.model.Direction;
import com.project.pawtropoliss.map.MapController;
import com.project.pawtropoliss.command.CommandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.EnumMap;
import java.util.Map;

@Controller
public class GameController {

    private final MapController mapGame;

    private final InputController inputController;

    @Autowired
    private GameController(MapController mapGame, InputController inputController) {
        this.mapGame = mapGame;
        this.inputController = inputController;
    }

    public void playGame() {
        Bag bagPlayer = new Bag(20);
        Player player = new Player(bagPlayer);
        String playerName = inputController.getInputString("""
                
                Enter player name:\s
                """ + "> ");
        player.setName(playerName);
        inputController.getInputString("The player health is: " + "\n" + "> " + player.getMAX_LIFE());
        Map<CommandManager, ActionStrategy> actions = new EnumMap<>(CommandManager.class);
        actions.put(CommandManager.LOOK, new LookActionStrategy(mapGame.getCurrentRoom()));
        actions.put(CommandManager.BAG, new BagActionStrategy(bagPlayer));
        actions.put(CommandManager.QUIT, new ExitGameActionStrategy());
        actions.put(CommandManager.GO, new GoActionStrategy(mapGame));
        actions.put(CommandManager.GET, new GetActionStrategy(player, mapGame));
        actions.put(CommandManager.DROP, new DropActionStrategy(bagPlayer, mapGame, inputController));
        boolean playerQuit = false;
        do {
            String choice = inputController.getInputString( "> ");
            CommandManager action;
            try {
                action = CommandManager.valueOf(choice.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("\n Invalid choice. Please choose again.\n");
                continue;
            }
            ActionStrategy actionStrategy = actions.get(action);
            switch (action) {
                case LOOK -> actionStrategy = new LookActionStrategy(mapGame.getCurrentRoom());
                case BAG -> actionStrategy = new BagActionStrategy(bagPlayer);
                case QUIT -> {
                    actionStrategy = new ExitGameActionStrategy();
                    System.out.println(playerName + " ADIOS");
                    playerQuit = true;
                }
                case GO -> {
                    Direction direction = inputController.getInputDirection("\n Which direction do you want to go? (NORTH, SOUTH, EAST, WEST) \n");
                    GoActionStrategy goActionStrategy = (GoActionStrategy) actionStrategy;
                    goActionStrategy.setDirection(direction);
                }
                case GET -> {
                    String itemName = inputController.getInputItemName("\n Which item do you want to get? \n");
                    GetActionStrategy getActionStrategy = (GetActionStrategy) actionStrategy;
                    Item item = Item.builder().name(itemName).build();
                    getActionStrategy.setItem(item);
                }
            }
            actionStrategy.execute();

        } while (!playerQuit);
    }
}

