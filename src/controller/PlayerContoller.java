package controller;

import domain.Bag;
import domain.Item;
import domain.Player;
import domain.Room;

public class PlayerContoller {
    public static void main(String[] args) {
        Bag bagPlayer = new Bag();
        Room garden = new Room("Garden");
        Player player1 = new Player("Rita",10, bagPlayer,garden);
        Item item1 = new Item("Cuffie","Cuffie per sentire la musica", 3);
        Item item2 = new Item("walkie talkie", "necessario per sentire un amico in difficoltà o per chiedere soccorsi",4);
        player1.addItemBag(item1);
        player1.addItemBag(item2);
      //  System.out.println(player1);
        player1.availableSlotTobag();
        // System.out.println(player1);
       // System.out.println(bagPlayer);

        //player1.increaseLifePoints(1);
        player1.decreaseLifePoints(2);
        player1.isAlive();
        System.out.println(player1);
    }




}
