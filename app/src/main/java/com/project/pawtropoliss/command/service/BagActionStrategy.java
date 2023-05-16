package com.project.pawtropoliss.command.service;

import lombok.AllArgsConstructor;
import com.project.pawtropoliss.player.domain.Bag;
import com.project.pawtropoliss.player.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BagActionStrategy implements ActionStrategy {

    private Bag bag;

    @Autowired
    public BagActionStrategy(Bag bag) {
        this.bag = bag;
    }

    @Override
    public void execute() {
        String itemList = " ";
        if (bag.getItems().isEmpty()) {
            itemList += "The bag is empty";
        } else {
            for (Item item : bag.getItems()) {
                itemList += item.getName() + " , " + item.getDescription() + ", " + item.getOccupiedSlots() + " , ";
            }
            itemList = itemList.substring(0, itemList.length() - 2); // rimuove la virgola finale e lo spazio
        }
        System.out.println("In the bag there is: "+ itemList +"." + "\n There are still " +bag.getAvailableSlots() + " available slots.");
    }
}
