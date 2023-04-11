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
            System.out.print("Inserisci il nome del giocatore: ");
            String playerName = input.nextLine();
            System.out.print("Inserisci il livello del giocatore: ");
            int playerLevel = input.nextInt();
            input.nextLine(); // Consuma il newline rimasto dal nextInt()
            System.out.println("Inserisci il nome della stanza corrente puoi scegliere tra: garden, livingRoom and badRoom ");
            String curRoom = input.nextLine();
            Item intialItemPlayer = new Item("Knife", "oggetto iniziale del gioco", 2);
            bagPlayer1.addItem(intialItemPlayer);
            Room initialRoom = new Room(curRoom);//currentRoom
            Player player1 = new Player(playerName, playerLevel, bagPlayer1, initialRoom);//player1
            System.out.println("Il nuovo player è " + player1);
            Room bathroom = new Room("Bathroom");
        Room kitchen = new Room ("Kitchen");
        Room armory = new Room("Armory");
        Room noursey = new Room("Noursey");

        initialRoom.addAdJacentRoom(bathroom, Direction.NORTH);
        initialRoom.addAdJacentRoom(kitchen,Direction.SOUTH);
        initialRoom.addAdJacentRoom(armory,Direction.EAST);
        initialRoom.addAdJacentRoom(noursey,Direction.WEST);

        kitchen.addAdJacentRoom(bathroom, Direction.NORTH);
        kitchen.addAdJacentRoom(initialRoom,Direction.CENTRAL);
        kitchen.addAdJacentRoom(armory,Direction.EAST);
        kitchen.addAdJacentRoom(noursey,Direction.WEST);

        bathroom.addAdJacentRoom(initialRoom, Direction.CENTRAL);
        bathroom.addAdJacentRoom(kitchen,Direction.SOUTH);
        bathroom.addAdJacentRoom(armory,Direction.EAST);
        bathroom.addAdJacentRoom(noursey,Direction.WEST);

        armory.addAdJacentRoom(bathroom, Direction.NORTH);
        armory.addAdJacentRoom(kitchen,Direction.SOUTH);
        armory.addAdJacentRoom(initialRoom,Direction.CENTRAL);
        armory.addAdJacentRoom(noursey,Direction.WEST);

        noursey.addAdJacentRoom(bathroom, Direction.NORTH);
        noursey.addAdJacentRoom(kitchen,Direction.SOUTH);
        noursey.addAdJacentRoom(armory,Direction.EAST);
        noursey.addAdJacentRoom(initialRoom,Direction.CENTRAL);

        Item item0 = new Item("walkie talkie", "necessario per sentire un amico in difficoltà o per chiedere soccorsi",4);
        Item item1 = new Item("carta igienica","necessario per pulire i bisogni", 3);
        Item item2 = new Item("banana","cibo", 1);
        Item item3 = new Item("acqua", "bere",1);
        Item item4 = new Item("Kalashnikov", "mitragliatore",6);
        Item item5 = new Item("macete", "arma da taglio",4);
        Item item6 = new Item("bende mediche", "servono per bendare le ferite",1);
        Item item7 = new Item("erba curativa", "erba verde stile Resident Evil",3);
        initialRoom.addItem(item0);
        bathroom.addItem(item1);
        kitchen.addItem(item2);
        kitchen.addItem(item3);
        armory.addItem(item4);
        armory.addItem(item5);
        noursey.addItem(item6);
        noursey.addItem(item7);
        Animal animal1 = new Animal("Hearth Lion ","carne cruda", LocalDate.now(),70.00, 8.50);
        initialRoom.addAnimal(animal1);
        Animal animal2 = new Animal("Tiger wolf","carne", LocalDate.now(),80.00, 6.50);
        Animal animal3 = new Animal("Eagle Pincopallino","carne", LocalDate.now(),30.00, 2.50);
        Animal animal4 = new Animal("Lion Biricchino","carne", LocalDate.now(),90.00, 7.50);
        bathroom.addAnimal(animal2);
        armory.addAnimal(animal3);
        noursey.addAnimal(animal4);

        System.out.println("Premi invio per guardare intorno nella stanza corrente. ");
        input.nextLine();
        System.out.println(initialRoom.look());
        System.out.print("Inserisci l'oggetto che vuoi prendere: ");
        String itemGet = input.nextLine();
        System.out.println(player1.get(itemGet));

        System.out.print("Inserisci l'oggetto che vuoi far cadere: ");
        String itemDrop = input.nextLine();
        System.out.println(player1.drop(itemDrop));

        String directionString;
        do {
            System.out.print("Inserisci la direzione in cui vuoi andare (NORTH, SOUTH, EAST , WEST o CENTRAL(se non sei già nella current room)) oppure premi ENTER per non cambiare stanza: ");
            directionString = input.nextLine();
            if (!directionString.isEmpty()) {
                try {
                    Direction direction = Direction.valueOf(directionString.toUpperCase());
                    System.out.println(player1.go(player1, direction));
                } catch (IllegalArgumentException e) {
                    System.out.println("Inserimento non valido. Riprova.");
                }
                System.out.print("Inserisci l'oggetto che vuoi prendere (Inserisci nothing se non vuoi prendere nulla): ");
                itemGet = input.nextLine();
                System.out.println(player1.get(itemGet));

                System.out.print("Inserisci l'oggetto che vuoi far cadere (inserisci nothing se non vuoi lasciare nessun oggetto): ");
                itemDrop = input.nextLine();
                System.out.println(player1.drop(itemDrop));

                System.out.println("Il contenuto della borsa del player1 è "+ player1.getItemsInThePlayerBag()); 
            }
        } while (!directionString.isEmpty());
        }catch (InputMismatchException e){
            System.out.println("Non hai inserito l'input corretto");
        }
        input.close();
    }

    }

