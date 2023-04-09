package domain;

import java.util.Optional;
import java.util.logging.Logger;

public class Player {
    private String name;
    private int health;
    private Bag bag;
    private Room currentRoom;


    private final Logger LOGGER = Logger.getLogger("myLogger");
    private final int MIN_LIFE_POINTS = 0;
    private final int MAX_LIFE_POINTS = 100;

    public Player(String name, int health, Bag bag, Room currentRoom) {
        this.name = name;
        this.health = health;
        this.bag = bag;
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

 /*aggiungere un oggetto in bag*/
    public Item addItemBag(Item item) {
        if (bag == null) {
            throw new IllegalStateException("bag field is null");
        }
        try {
            return bag.addItem(item);
        } catch (IllegalStateException e) {
            System.out.println("bag is full");
        } catch (IllegalArgumentException e) {
            System.out.println("item already exists in bag");
        }
        return item;
    }
   /*rimozione oggetto */
    public Item removeItemBag(Item item){
        return bag.removeItem(item);
    }
    /*rimozione dell'oggetto tramite nome*/
    public Item removeItemBagByNAme(String nameItem){
        return bag.removeItemByName(nameItem);
    }
    /*rimozione tutti oggetti*/
    public void removeallItemBag(){
        bag.removeAllItemsBag();
    }
    /*Ricerca oggetto per nome*/
    public Item serachItemByName(String nameItem){
        return bag.searchItemByName(nameItem);
    }


    public void increaseLifePoints(int point) {
        if (point <= 0) {
            throw new IllegalArgumentException("The life point must be a positive integer");
        }
        int newLifePoints = Math.min(health + point, MAX_LIFE_POINTS);
        health = newLifePoints;
    }
    public void availableSlotTobag(){
        bag.availableSlot();
    }
    public void decreaseLifePoints(int point) {
        if (point <= 0) {
            throw new IllegalArgumentException("The life point must be a positive integer");
        }
        int newLifePoints = Math.max(health - point, MIN_LIFE_POINTS);
        health = newLifePoints;
        if (health == 0) {
            LOGGER.info("Player is dead");
        }
    }
    /*metodo go*/
    public String go(Player player, Direction direction) {
        Room adjacentRoom = null;
        String trueParameter = "You are ";
        String falseParameter = "There is no room in that direction ";
        Optional<Room> adjacentRoomOptional = player.getCurrentRoom().getAdjacentRoom(direction);
        if (adjacentRoomOptional.isPresent()) {
            adjacentRoom = adjacentRoomOptional.get();
            player.setCurrentRoom(adjacentRoom);
            return  trueParameter + adjacentRoom.look();
        } else {
            return falseParameter;
        }
    }
   /* public String printBagContents() {
        String bagItem = "The items in the bag are ";
        String bagEmpty = "Bag is empty ";
        System.out.print("In bag: ");
        if (bag != null) {
            for (Item item : bag.getItems()) {
             return bagItem + item.getNameItem() + ", ";
            }
        }  return bagEmpty;
    }*/
   /*Elenca il contenuto della borsa del giocatore*/
    public String getItemsInThePlayerBag() {
        String itemList = "In bag: ";
        if (bag.getItems().isEmpty()) {
            itemList += "empty";
        } else {
            for (Item item : bag.getItems()) {
                itemList += item.getNameItem() + ", ";
            }
            itemList = itemList.substring(0, itemList.length() - 2); // remove the trailing comma and space
        }
        return itemList;
    }
    public boolean isAlive() {
        return health > 0;
    }


    @Override
    public String toString() {
        return "Player --> " +
                "name " + name + '\'' +
                ", health " + health +
                ", bag " + bag;

    }


}
