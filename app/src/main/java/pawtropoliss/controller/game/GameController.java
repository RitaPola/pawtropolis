package pawtropoliss.controller.game;
import pawtropoliss.controller.input.InputController;
import pawtropoliss.controller.map.MapController;
import pawtropoliss.domain.command.*;
import pawtropoliss.domain.commandmanager.Command;
import pawtropoliss.domain.game.Bag;
import pawtropoliss.domain.game.Player;
import pawtropoliss.domain.mapmanager.Direction;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;


public class GameController {

    private static GameController instance;

    private final MapController mapGame;

    private boolean playerQuit;
    private final InputController inputController;

    private GameController() {
        this.mapGame = new MapController();
        this.inputController = new InputController();
        this.playerQuit = false;
    }
    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public boolean playerQuit(){
        playerQuit = false;
        return false;
    }
    public void playGame() {
        String playerName = inputController.getInputString("\n" + "Enter the player's name: ");
        int playerLevel = inputController.getInputInt("\n" + "Enter how much health the player has: ", 0, 100);
        Bag bagPlayer = new Bag(20);
        Player player = new Player(playerName, playerLevel, bagPlayer);
        Map<Command, Supplier<ActionStrategy>> actions = new EnumMap<>(Command.class);
        actions.put(Command.LOOK, () -> new LookActionStrategy(mapGame.getCurrentRoom()));
        actions.put(Command.BAG, () -> new BagActionStrategy(bagPlayer));
        actions.put(Command.QUIT, () -> new ExitGameActionStrategy());
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



        do {
            System.out.println(" What do you want to do? ");
            String choice = inputController.getInputString("");
            Command action = null;
            try {
                action = Command.valueOf(choice.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + "Invalid choice stronzo. Please choose again.");
                continue;
            }
            Supplier<ActionStrategy> actionSupplier = actions.get(action);
            ActionStrategy actionStrategy = actionSupplier.get();
            actionStrategy.execute();
            playerQuit = action == Command.QUIT;
        } while (!playerQuit);{
            playerQuit = true;
            System.out.println(playerName + " hai quittato il gioco");
        };
    }

}
