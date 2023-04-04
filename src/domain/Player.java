package domain;

import java.util.logging.Logger;

public class Player {
    private String name;
    private int health;
    private Bag bag;
    private final Logger LOGGER = Logger.getLogger("myLogger");
    private final int MIN_LIFE_POINTS = 0;
    private final int MAX_LIFE_POINTS = 100;

    public Player(String name, int health, Bag bag) {
        this.name = name;
        this.health = health;
        this.bag = bag;
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
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", bag=" + bag +
                '}';
    }


}
