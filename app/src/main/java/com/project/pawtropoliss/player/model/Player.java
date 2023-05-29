package com.project.pawtropoliss.player.model;

import com.project.pawtropoliss.game.input.InputController;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Data
public class Player {
    private String name;
    private int health;
    private static final int MAX_HEALTH_POINT = 20;
    private final Bag bag;

    @Autowired
    public Player(Bag bag) {
        this.name = InputController.getInputString("Insert player name : ");
        this.health = MAX_HEALTH_POINT;
        this.bag = bag;
    }
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

    public boolean isAlive() {
        return health > 0;
    }

}
