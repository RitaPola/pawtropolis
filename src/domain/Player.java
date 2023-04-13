package domain;

import java.util.logging.Logger;


public class Player{
    private String name;
    private int health;
    private Bag bag;
    private Room currentRoom;


    public Player(String name, int health, Bag bag, Room currentRoom) {
        this.name = name;
        this.health = health;
        this.bag = bag;
        this.currentRoom=currentRoom;

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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    /*aggiunge un oggetto nello zaino del giocatore*/
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

    /*rimozione oggetto dallo zaino del giocatore*/
    public Item removeItemBag(Item item) {
        return bag.removeItem(item);
    }

    /*rimozione dell'oggetto tramite nome*/
    public Item removeItemBagByName(String nameItem) {
        return bag.removeItemByName(nameItem);
    }

    /*rimuove tutti oggetti dallo zaino del giocatore*/
    public void removeallItemBag() {
        bag.removeAllItemsBag();
    }

    /*Ricerca oggetto per nome*/
    public Item serachItemByName(String nameItem) {
        return bag.searchItemByName(nameItem);
    }

    /*incrementa la vita del giocatore*/
    public void increaseLifePoints(int point) {
        if (point <= 0) {
            throw new IllegalArgumentException("The life point must be a positive integer");
        }
        int newLifePoints = Math.min(health + point, 100);
        health = newLifePoints;
    }

    /*verifica gli slot disponibili nella borsa*/
    public void availableSlotTobag() {
        bag.availableSlot();
    }

    /*Decrementa la vita del giocatore*/
    public void decreaseLifePoints(int point) {
        Logger LOGGER = Logger.getLogger("myLogger");
        if (point <= 0) {
            throw new IllegalArgumentException("The life point must be a positive integer");
        }
        int newLifePoints = Math.max(health - point, 0);
        health = newLifePoints;
        if (health == 0) {
            LOGGER.info("Player is dead");
        }
    }
    /*verifica se il player è vivo*/
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
