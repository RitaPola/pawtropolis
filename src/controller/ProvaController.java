package controller;

import domain.Item;
import domain.Room;
import gestionezoo.Animal;

import java.time.LocalDate;

public class ProvaController {
    public static void main(String[] args) {
      /*  Bag bag = new Bag(20);
        System.out.println(bag);
        Bag bag1 = new Bag();
        System.out.println(bag1);*/
/* Item items = new Item("ciao","balsamo",2);
        Item item2 = new Item ("Ciao2","blabla",3);
        bag.addItem(items);
        bag.addItem(item2);
        System.out.println("oggetto rimosso " + bag.removeItemByName("ciao"));
        System.out.println("slot disponibili " + bag.checkAvailableSlotsInTheBag());
        //System.out.println(bag);
       // bag.removeAllItemFromTheBag();
       System.out.println(bag.checkItemsInTheBag());*/
       // System.out.println(bag);
        Animal animal1 = new Animal("Lion Hearth", "carne cruda", LocalDate.now(), 70.00, 8.50);
        Room room1 = new Room("room1");
        room1.addAnimalInTheRoom(animal1);
        System.out.println(room1.getAnimalByNameInTheRoom("Lion Hearth"));
        System.out.println(room1.removeAnimalByNameInTheRoom("Lion Hearth"));
       System.out.println(room1.look());
        Item items = new Item("ciao","balsamo",2);
        room1.addItemInTheRoom(items);

        System.out.println(room1.getItemByNameInTheRoom( "palla" ));

     //   System.out.println(room1.removeItemInTheRoom(items));

    }



}
