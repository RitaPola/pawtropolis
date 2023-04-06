package controller;

import domain.Direction;
import domain.Room;
import gestionezoo.Animal;
import gestionezoo.Lion;

import java.time.LocalDate;

public class RoomController {

    public static void main(String[] args) {
        Room room1 = new Room("Garden");
        Animal animal1 = new Animal("Lion","carne cruda", LocalDate.now(),70.00, 3.50);
        room1.addAnimal(animal1);

       System.out.println(room1.addAdJacentRoom(room1,Direction.SOUTH));
    }
}
