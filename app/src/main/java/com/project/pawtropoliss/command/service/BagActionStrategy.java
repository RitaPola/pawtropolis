package com.project.pawtropoliss.command.service;

import lombok.AllArgsConstructor;
import com.project.pawtropoliss.player.domain.Bag;
import com.project.pawtropoliss.player.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BagActionStrategy implements ActionStrategy {
    private final Bag bag;

    @Autowired
    public BagActionStrategy(Bag bag) {
        this.bag = bag;
    }

    @Override
    public void execute() {
        List<Item> items = bag.getItems();
        int availableSlots = bag.getAvailableSlots();
        StringBuilder itemList = new StringBuilder();

        for (Item item : items) {
            itemList.append(item.getName()).append(" - ").append(item.getDescription()).append(" - ");
        }

        if (itemList.length() > 0) {
            itemList.setLength(itemList.length() - 2); // Rimuove la virgola finale e lo spazio
            System.out.println("\n In the bag there is: " + itemList + ".\n");
        }

        System.out.println("\n There are still " + availableSlots + " available slots. \n");
    }
}
