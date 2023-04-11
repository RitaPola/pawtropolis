package controller;

import domain.Bag;
import domain.Item;

public class BagController {
    public static void main(String[] args) {
        Item item1 = new Item("Cuffie","Cuffie per sentire la musica", 3);
        Item item2 = new Item("walkie talkie", "necessario per sentire un amico in difficoltà o per chiedere soccorsi",4);


        Bag bag1 = new Bag();
       // System.out.println(bag1.fullBag());
        bag1.addItem(item1);
        bag1.addItem(item2);
      System.out.println(bag1.availableSlot());
      /*  System.out.println(bag1);
        bag1.availableSlot();
        System.out.println(bag1);*/
    /*  System.out.println("l'oggetto rimosso è: " + bag1.removeItem(item2));
       System.out.println(bag1.getAvailableSlots());
       bag1.clearAllItemList();
       System.out.println(bag1);
       System.out.println(bag1.getItemByName("cuffie"));
       System.out.println(bag1.removeByName("Cacca"));
       bag1.removeByName("Cuffie");
       System.out.println(bag1);
       System.out.println(bag1.availableSlot());*/
      // System.out.println(bag1.searchItemByName("cacca"));
    }
}
