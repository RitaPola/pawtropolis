package controller.game;
import model.map.MapCreator;
import domain.player.Bag;
import domain.player.Player;
import gamestrategy.*;
import model.map.Direction;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class GameController {

    private static GameController instance;

    private final MapCreator mapGame;

    private GameController() {
        this.mapGame = new MapCreator();
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }
    public void playGame() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n" + "Enter the player's name: ");
        String playerName = input.nextLine();
        System.out.print("\n" + "Enter how much health the player has: ");
        int playerLevel = input.nextInt();
        input.nextLine();
        Bag bagPlayer = new Bag(20);
        Player player = new Player(playerName, playerLevel, bagPlayer);

        Map<String, Supplier<ActionStrategy>> actions = new HashMap<>();
        actions.put("LOOK", () -> new LookActionStrategy(mapGame.getCurrentRoom()));
        actions.put("BAG", () -> new BagActionStrategy(bagPlayer));
        actions.put("QUIT GAME", () -> new ExitGameActionStrategy(playerName));
        actions.put("GO", () -> {
            System.out.println("\n" + "Which direction do you want to go? (NORTH, SOUTH, EAST, WEST)");
            String directionInput = input.nextLine();
            Direction direction = Direction.valueOf(directionInput.toUpperCase());
            return new GoActionStrategy(mapGame, direction);
        });

        actions.put("GET", () -> {
            System.out.println("\n" + "Which item do you want to get?");
            String itemName = input.nextLine();
            return new GetActionStrategy(itemName, player, mapGame);
        });

        actions.put("DROP", () -> {
            System.out.println("\n" + "Which item do you want to drop?");
            String itemName = input.nextLine();
            return new DropActionStrategy(player.getBagPlayer(), itemName, mapGame);
        });
        boolean exitGame = false;
        do {
            System.out.print("""
                                                
                    What do you want to do?
                           
                    """);
            String choice = input.nextLine().toUpperCase();
            Supplier<ActionStrategy> actionSupplier = actions.get(choice);
            if (actionSupplier == null) {
                System.out.println("\n" + "Invalid choice. Please choose again.");
                continue;
            }
            ActionStrategy actionStrategy = actionSupplier.get();
            actionStrategy.execute();
            exitGame = choice.equalsIgnoreCase("EXIT");
        } while (!exitGame);
    }

}
