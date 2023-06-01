package com.project.pawtropoliss.persistance.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
@Entity
@Table(name = "bags")
public class Bag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private static final int TOTAL_SLOTS = 15;
    private int availableSlots;
    @Column(name = "total_slots")
    private final int maxSlots;

    private final List<Item> items;

    public Bag() {
        this(TOTAL_SLOTS);
    }

    public Bag(int maxSlot) {
        this.maxSlots = maxSlot;
        this.availableSlots = maxSlot;
        this.items = new ArrayList<>(maxSlot);
    }

    public boolean addItem(Item item) {
        if (availableSlots - item.getReqiuredSlots() >= 0) {
            items.add(item);
            availableSlots -= item.getReqiuredSlots();
            return true;
        }
        return false;
    }

    public Item removeItem(Item item) {
        if (items.remove(item)) {
            availableSlots += item.getReqiuredSlots();
            return item;
        }
        return null;
    }

    public Item getItemByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }

    public void removeAllItems() {
        items.clear();
    }

    public Item removeItemByName(String nameToRemove) {
        return items.stream().filter(itemCurrent -> itemCurrent.getName().equalsIgnoreCase(nameToRemove))
                .findAny()
                .map(itemCurrent -> {
                    items.remove(itemCurrent);
                    availableSlots += itemCurrent.getReqiuredSlots();
                    return itemCurrent;
                }).orElse(null);
    }

    public int checkItemsInTheBag() {
        return items.size();
    }

    public boolean checkAvailableSlotsInTheBag(Item item) {
        return availableSlots - item.getReqiuredSlots() >= 0;
    }
}
