package controller;

import domain.Direction;
import domain.Item;
import domain.Room;
import gestionezoo.Animal;
import gestionezoo.Lion;

import java.time.LocalDate;

public class RoomController {

    public static void main(String[] args) {
        Room garden = new Room("Garden");
        Animal animal1 = new Animal("Lion","carne cruda", LocalDate.now(),70.00, 3.50);
        Item item1 = new Item("Mouse","muove il puntatore di un computer", 2);
        Room bathroom = new Room("bathroom");
        garden.addAnimal(animal1);
        garden.addItem(item1);
        garden.addAdJacentRoom(garden,Direction.WEST);
        garden.addAdJacentRoom(bathroom,Direction.SOUTH);
        System.out.println(garden);
    }
}
