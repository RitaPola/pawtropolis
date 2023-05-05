package pawtropoliss.controller.startgame;
import pawtropoliss.controller.input.InputController;
import pawtropoliss.controller.map.MapController;
import pawtropoliss.domain.command.*;
import pawtropoliss.domain.commandmanager.Command;
import pawtropoliss.domain.game.Bag;
import pawtropoliss.domain.game.Player;
import pawtropoliss.domain.mapmanager.Direction;
import java.util.EnumMap;
import java.util.Map;


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
        Map<Command, ActionStrategy> actions = new EnumMap<>(Command.class);
        actions.put(Command.LOOK, new LookActionStrategy(mapGame.getCurrentRoom()));
        actions.put(Command.BAG, new BagActionStrategy(bagPlayer));
        actions.put(Command.QUIT, new ExitGameActionStrategy());
        actions.put(Command.GO, new GoActionStrategy(mapGame, null));
        actions.put(Command.GET, new GetActionStrategy(null, null, null));
        actions.put(Command.DROP, new DropActionStrategy(null, null, null));
        boolean playerQuit = false;
        do {
            System.out.println("What do you want to do?");
            String choice = inputController.getInputString("");
            Command action = null;
            try {
                action = Command.valueOf(choice.toUpperCase());
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
