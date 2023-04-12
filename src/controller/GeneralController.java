package controller;

import domain.*;
import gestionezoo.Animal;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GeneralController {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bag bagPlayer1 = new Bag();
        try {
            System.out.print("\n" + "Enter the player's name: ");
            String playerName = input.nextLine();
            System.out.print("\n" + "Enter how much health the player has: ");
            int playerLevel = input.nextInt();
            input.nextLine(); // Consuma il newline rimasto dal nextInt()
            System.out.println("\n" + "Enter the name of the current room you can choose between: garden, livingRoom and bedRoom ");
            String curRoom = input.nextLine();
            Item intialItemPlayer = new Item("knife", "starting object of the game", 2);
            bagPlayer1.addItem(intialItemPlayer);
            Room initialRoom = new Room(curRoom);//currentRoom
            Player player1 = new Player(playerName, playerLevel, bagPlayer1, initialRoom);//player1
            System.out.println("\n" + "The new Player is: " + player1);
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
            Item item7 = new Item("healing herb", "Resident Evil style green grass", 3);
            initialRoom.addItem(item0);
            bathroom.addItem(item1);
            kitchen.addItem(item2);
            kitchen.addItem(item3);
            armory.addItem(item4);
            armory.addItem(item5);
            noursey.addItem(item6);
            noursey.addItem(item7);
            Animal animal1 = new Animal("Lion Hearth ", "carne cruda", LocalDate.now(), 70.00, 8.50);
            initialRoom.addAnimal(animal1);
            Animal animal2 = new Animal("Tiger wolf", "meat", LocalDate.now(), 80.00, 6.50);
            Animal animal3 = new Animal("Eagle Pincopallino", "meat", LocalDate.now(), 30.00, 2.50);
            Animal animal4 = new Animal("Lion Biricchino", "meat", LocalDate.now(), 90.00, 7.50);
            bathroom.addAnimal(animal2);
            armory.addAnimal(animal3);
            noursey.addAnimal(animal4);

            System.out.println("\n" + "Hit enter to look around the current room.");
            input.nextLine();
            System.out.println(initialRoom.look());
            System.out.print("\n" + "Enter the item you want to take or press no to take nothing: ");
            String itemGet = input.nextLine();
            System.out.println(player1.get(itemGet));

            System.out.print("\n" + "Enter the object you want to drop or press no to leave nothing: ");
            String itemDrop = input.nextLine();
            System.out.println(player1.drop(itemDrop));
            System.out.println("\n" + "The contents of player1's bag is: " + player1.getItemsInThePlayerBag());

            String directionString;
            do {
                System.out.print("\n" + "Enter the direction you want to go (NORTH, SOUTH, EAST , WEST or CENTRAL (if you are not already in the current room)) or press ENTER to not change the room: ");
                directionString = input.nextLine();
                if (!directionString.isEmpty()) {
                    try {
                        Direction direction = Direction.valueOf(directionString.toUpperCase());
                        System.out.println(player1.go(player1, direction));
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + "Invalid entry. Try again. ");
                    }
                    System.out.println("\n" + "Enter the item you want to take or press no to take nothing: ");
                    itemGet = input.nextLine();
                    System.out.println(player1.get(itemGet));

                    System.out.print("\n" + "Enter the object you want to drop or press no to leave nothing: ");
                    itemDrop = input.nextLine();
                    System.out.println(player1.drop(itemDrop));

                    System.out.println("\n" + "The contents of player1's bag is: " + player1.getItemsInThePlayerBag());
                }
            } while (!directionString.isEmpty());
        } catch (InputMismatchException e) {
            System.out.println("\n" + "You have not entered the correct input ");
        }
        input.close();
    }
}


