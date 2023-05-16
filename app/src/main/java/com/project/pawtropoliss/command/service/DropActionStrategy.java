package com.project.pawtropoliss.command.service;

import lombok.AllArgsConstructor;
import com.project.pawtropoliss.map.MapController;
import com.project.pawtropoliss.player.domain.Bag;
import com.project.pawtropoliss.player.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DropActionStrategy implements ActionStrategy {
    private final Bag bag;
    private final String itemName;
    private final MapController currentRoom;

    @Override
    public void execute() {
        if (bag.getItems().isEmpty()) {
            System.out.println("There are no items in the bag");
            return;
        }

        Item item = bag.removeItemByName(itemName);

        if (itemName == null || itemName.equalsIgnoreCase("no") || itemName.equals("")) {
            System.out.println("You have not specified an item to drop");
            return;
        }

        if (item == null) {
            System.out.println("Item not found in the bag");
            return;
        }

        if (!currentRoom.getCurrentRoom().addItemInTheRoom(item)) {
            bag.addItem(item);
            System.out.println("Room is full, cannot drop the item");
        }
    }
}
