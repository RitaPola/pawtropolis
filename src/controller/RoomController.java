package controller;

import domain.*;
import gestionezoo.Animal;
import gestionezoo.Lion;

import java.time.LocalDate;

public class RoomController {

    public static void main(String[] args) {
        Room garden = new Room("Garden");
        Animal animal1 = new Animal("Lion","carne cruda", LocalDate.now(),70.00, 3.50);
        Room bathroom = new Room("Bathroom");
        garden.addAnimal(animal1);
        garden.addAdJacentRoom(garden,Direction.WEST);
        garden.addAdJacentRoom(bathroom,Direction.SOUTH);
        Bag bagPlayer = new Bag();
        Player player1 = new Player("Rita",10, bagPlayer, garden);
        Item item1 = new Item("Mouse","muove il puntatore di un computer", 2);
        Item item2 = new Item("Cuffie","Cuffie per sentire la musica", 3);
        Item item3 = new Item("walkie talkie", "necessario per sentire un amico in difficoltà o per chiedere soccorsi",4);
        player1.addItemBag(item2);
        player1.addItemBag(item3);
        garden.addItem(item1);
        player1.get("Mouse");
        System.out.println(player1.getItemsInThePlayerBag());
        System.out.println(player1.drop("Mouse"));
        System.out.println(player1.drop("Mouse"));
        System.out.println(garden.look());



        //System.out.println(player1.go(player1,Direction.SOUTH));





    }
}
