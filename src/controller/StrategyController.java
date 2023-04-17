package controller;

import domain.*;
import gameStrategy.*;
import gestionezoo.Animal;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StrategyController {
    public static void main(String[] args) {
     /*   Scanner input = new Scanner(System.in);
        try {
            System.out.print("\n" + "Enter the player's name: ");
            String playerName = input.nextLine();
            System.out.print("\n" + "Enter how much health the player has: ");
            int playerLevel = input.nextInt();
            input.nextLine(); // Consume the newline left by nextInt()
            System.out.println("\n" + "Enter the name of the current room you can choose between: garden, livingRoom and bedRoom");
            String curRoom = input.nextLine();
            Bag bagPlayer1 = new Bag();
            Room initialRoom = new Room(curRoom);

            Player player = new Player(playerName, playerLevel, bagPlayer1, initialRoom);
            Room bathroom = new Room("Bathroom");
            Room kitchen = new Room("Kitchen");
            Room armory = new Room("Armory");
            Room noursey = new Room("Noursey");

            initialRoom.addAdJacentRoom(bathroom, Direction.NORTH);
            initialRoom.addAdJacentRoom(kitchen, Direction.SOUTH);
            initialRoom.addAdJacentRoom(armory, Direction.EAST);
            initialRoom.addAdJacentRoom(noursey, Direction.WEST);

            kitchen.addAdJacentRoom(bathroom, Direction.NORTH);
            kitchen.addAdJacentRoom(initialRoom, Direction.CENTRAL);
            kitchen.addAdJacentRoom(armory, Direction.EAST);
            kitchen.addAdJacentRoom(noursey, Direction.WEST);

            bathroom.addAdJacentRoom(initialRoom, Direction.CENTRAL);
            bathroom.addAdJacentRoom(kitchen, Direction.SOUTH);
            bathroom.addAdJacentRoom(armory, Direction.EAST);
            bathroom.addAdJacentRoom(noursey, Direction.WEST);

            armory.addAdJacentRoom(bathroom, Direction.NORTH);
            armory.addAdJacentRoom(kitchen, Direction.SOUTH);
            armory.addAdJacentRoom(initialRoom, Direction.CENTRAL);
            armory.addAdJacentRoom(noursey, Direction.WEST);

            noursey.addAdJacentRoom(bathroom, Direction.NORTH);
            noursey.addAdJacentRoom(kitchen, Direction.SOUTH);
            noursey.addAdJacentRoom(armory, Direction.EAST);
            noursey.addAdJacentRoom(initialRoom, Direction.CENTRAL);

            Item item0 = new Item("walkie talkie", "Necessary to hear a friend in distress or to ask for help", 4);
            Item item1 = new Item("toilet paper", "clean needs", 3);
            Item item2 = new Item("banana", "food", 1);
            Item item3 = new Item("acqua", "water", 1);
            Item item4 = new Item("Kalashnikov", "mitragliatore", 6);
            Item item5 = new Item("machete", "cutting weapon", 4);
            Item item6 = new Item("medical bandages", "they are used to bandage wounds", 1);
            Item item7 = new Item("healing herb", "Resident Evil style green herb", 3);
            initialRoom.addItem(item0);
            bathroom.addItem(item1);
            kitchen.addItem(item2);
            kitchen.addItem(item3);
            armory.addItem(item4);
            armory.addItem(item5);
            noursey.addItem(item6);
            noursey.addItem(item7);
*/
            /*Creazione animali*/
        /*    Animal animal1 = new Animal("Lion Hearth ", "carne cruda", LocalDate.now(), 70.00, 8.50);
            Animal animal2 = new Animal("Tiger wolf", "meat", LocalDate.now(), 80.00, 6.50);
            Animal animal3 = new Animal("Eagle Pincopallino", "meat", LocalDate.now(), 30.00, 2.50);
            Animal animal4 = new Animal("Lion Biricchino", "meat", LocalDate.now(), 90.00, 7.50);

*/
            /*Aggiunta degli animali alle rispettive stanze*/
    /*        initialRoom.addAnimal(animal1);
            bathroom.addAnimal(animal2);
            armory.addAnimal(animal3);
            noursey.addAnimal(animal4);

            while (true) {
                System.out.print("""
                                            
                          What do you want to do?
                          
                          1. Look around
                          
                          2. Go to a different room
                          
                          3. Get an item
                          
                          4. Drop an item
                          
                          5. Check inventory
                          
                          6. Quit the game
                         
                        """);
                int choice = input.nextInt();
                input.nextLine(); // Consume the newline left by nextInt()

                ActionStrategy actionStrategy;
                switch (choice) {
                    case 1:
                        actionStrategy = new LookActionStrategy(player.getCurrentRoom());
                        break;
                    case 2:
                        System.out.println("\n" + "Which direction do you want to go? (NORTH, SOUTH, EAST, WEST OR CENTRAL)");
                        String directionInput = input.nextLine();
                        Direction direction = Direction.valueOf(directionInput.toUpperCase());
                        actionStrategy = new GoActionStrategy(player, direction);
                        break;
                    case 3:
                        System.out.println("\n" + "Which item do you want to get?");
                        String itemName = input.nextLine();
                        actionStrategy = new GetActionStrategy(player.getCurrentRoom(), itemName, player);
                        break;
                    case 4:
                        System.out.println("\n" + "Which item do you want to drop?");
                        itemName = input.nextLine();
                        actionStrategy = new DropActionStrategy(player.getBag(), itemName, player.getCurrentRoom());
                        break;
                    case 5:
                        actionStrategy = new BagActionStrategy(player.getBag());
                        System.out.println("Available slot " + bagPlayer1.checkAvailableSlotsInTheBag() + "\n");
                        break;
                    case 6:
                        System.out.println("\n" + "Thanks for playing!");
                        return;
                    default:
                        System.out.println("\n" + "Invalid choice. Please choose again.");
                        continue;
                }
                String result = actionStrategy.execute();
                System.out.println(result);
            }
        }catch (InputMismatchException e) {
            System.out.println("\n" + "You have not entered the correct input ");
        }
        input.close();
        */
    }

    }

