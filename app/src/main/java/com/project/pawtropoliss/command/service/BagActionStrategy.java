package com.project.pawtropoliss.command.service;
import com.project.pawtropoliss.player.domain.Bag;
import com.project.pawtropoliss.player.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BagActionStrategy implements ActionStrategy {
    private final Bag bag;

    @Autowired
    public BagActionStrategy(Bag bag) {
        this.bag = bag;
    }

    @Override
    public void execute() {
        List <Item> items = bag.getItems();
        int availableLots = bag.getAvailableSlots();
        String itemList = items.stream()
                .map(item -> item.getName() + " - " + item.getDescription() + " - ")
                .collect(Collectors.joining(" - "));//unisce le stringhe con -
        if (!itemList.isEmpty()) {
            System.out.println("\n In the bag there is: " + itemList + ".\n");
        }
        System.out.println("\n There are still " + availableLots + " available slots. \n");
    }
}
