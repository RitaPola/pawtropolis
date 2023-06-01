package com.project.pawtropoliss.persistance.entity;
import lombok.*;
import javax.persistence.*;
import java.util.logging.Logger;


@Data
@Entity
@Table(name = "players" )
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "health")
    private int health;
    private static final int MAX_HEALTH_POINT = 20;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bag_id", referencedColumnName = "id")
    private Bag bag;

    public Player(){
    }
/*
   @Autowired
    public Player(Bag bag) {
        this.name = InputController.getInputString("Insert player name : ");
        this.health = MAX_HEALTH_POINT;
        this.bag = bag;
    }*/
    public void addItemInTheBag(Item item) {
        if (bag.getAvailableSlots() >= item.getReqiuredSlots()) {
            bag.addItem(item);
        }
    }
    public void removeItemFromTheBag(Item item) {
        bag.removeItem(item);
    }

    public Item removeItemFromTheBagByName(String nameItem) {
        return bag.removeItemByName(nameItem);
    }

    public void removeAllItemFromTheBag() {
        bag.removeAllItems();
    }

    public Item getItemFromTheBagByName(String nameItem) {
        return bag.getItemByName(nameItem);
    }

    public boolean availableSlotsInBag(Item item) {
        return bag.checkAvailableSlotsInTheBag(item);
    }

    public void increasePlayerHealth(int point) {
        if (point <= 0) {
            throw new IllegalArgumentException("The life point must be a positive integer");
        }
        health = Math.min(health + point, 100);
    }

    public void decreasePlayerHealth(int point) {
        Logger LOGGER = Logger.getLogger("myLogger");
        if (point <= 0) {
            throw new IllegalArgumentException("The life point must be a positive integer");
        }
        int delta = health - point;
        health = Math.max(delta, 0);
        if (health == 0) {
            LOGGER.info("Player is dead");
        }
    }

    public boolean alive() {
        return health > 0;
    }

}

