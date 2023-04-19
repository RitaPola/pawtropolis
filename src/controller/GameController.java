package controller;

import domain.Bag;
import domain.Player;
import gameStrategy.*;
import mapcontroller.CreationMap;
import mapcontroller.Direction;
import mapcontroller.Room;

import java.util.Scanner;

public class GameController {

    private static GameController instance;

    private CreationMap mapGame;

    public boolean changeRoom(Direction direction) {
        return mapGame.changeRoom(direction);
    }
    public Room getCurrentRoom() {
        return mapGame.getCurrentRoom();
    }

    private GameController() {
        this.mapGame = new CreationMap();
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

        while (true) {
            System.out.print("""
                                                
                  What do you want to do?
                  
                  1. Look around
                  
                  2. Go to a different room
                  
                  3. Get an item
                  
                  4. Drop an item
                  
                  5. Check inventory
                  
                  6. Exit the game
                 
                """);
            String choice = input.nextLine().toUpperCase();

            ActionStrategy actionStrategy;
            switch (choice) {
                case "LOOK":
                    actionStrategy = new LookActionStrategy(mapGame.getCurrentRoom());
                    break;
                case "GO":
                    System.out.println("\n" + "Which direction do you want to go? (NORTH, SOUTH, EAST, WEST OR CENTRAL)");
                    String directionInput = input.nextLine();
                    Direction direction = Direction.valueOf(directionInput.toUpperCase());
                    actionStrategy = new GoActionStrategy();
                    break;
                case "GET":
                    System.out.println("\n" + "Which item do you want to get?");
                    String itemName = input.nextLine();
                    actionStrategy = new GetActionStrategy(itemName,player,mapGame);
                    break;
                case "DROP":
                    System.out.println("\n" + "Which item do you want to drop?");
                    itemName = input.nextLine();
                    actionStrategy = new DropActionStrategy(player.getBagPlayer(), itemName, mapGame);
                    break;
                case "BAG":
                    actionStrategy = new BagActionStrategy(bagPlayer);
                    break;
                case "EXITGAME":
                    System.out.println("\n" + "Thanks for playing!");
                    return;
                default:
                    System.out.println("\n" + "Invalid choice. Please choose again.");
                    continue;
            }
            actionStrategy.execute();
        }
    }
}
