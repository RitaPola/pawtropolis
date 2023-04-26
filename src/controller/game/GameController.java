package controller.game;
import controller.input.InputController;
import controller.map.MapController;
import domain.commandmanager.Command;
import domain.game.Bag;
import domain.game.Player;
import domain.command.*;
import domain.mapmanager.Direction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameController {

    private static GameController instance;

    private final MapController mapGame;

    private final InputController inputController;

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
        int playerLevel = inputController.getInputInt("\n" + "Enter how much health the player has: ", 0, 100);
        Bag bagPlayer = new Bag(20);
        Player player = new Player(playerName, playerLevel, bagPlayer);

        Map<Command, Supplier<ActionStrategy>> actions = new HashMap<>();
        actions.put(Command.LOOK, () -> new LookActionStrategy(mapGame.getCurrentRoom()));
        actions.put(Command.BAG, () -> new BagActionStrategy(bagPlayer));
        actions.put(Command.QUIT_GAME, () -> new ExitGameActionStrategy(playerName));
        actions.put(Command.GO, () -> {
            Direction direction = inputController.getInputDirection("\n" + "Which direction do you want to go? (NORTH, SOUTH, EAST, WEST) ");
            return new GoActionStrategy(mapGame, direction);
        });

        actions.put(Command.GET, () -> {
            String itemName = inputController.getInputItemName("\n" + "Which item do you want to get? ");
            return new GetActionStrategy(itemName, player, mapGame);
        });

        actions.put(Command.DROP, () -> {
            String itemName = inputController.getInputItemName("\n" + "Which item do you want to drop? ");
            return new DropActionStrategy(player.getBagPlayer(), itemName, mapGame);
        });

        boolean exitGame = false;
        do {
            System.out.print("""
                                
                What do you want to do?
                       
                """);
            String choice = inputController.getInputString("");
            Command action = null;
            try {
                action = Command.valueOf(choice.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + "Invalid choice. Please choose again.");
                continue;
            }
            Supplier<ActionStrategy> actionSupplier = actions.get(action);
            ActionStrategy actionStrategy = actionSupplier.get();
            actionStrategy.execute();
            exitGame = action == Command.QUIT_GAME;
        } while (!exitGame);
    }

}
