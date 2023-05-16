package com.project.pawtropoliss.command.service;

import com.project.pawtropoliss.game.input.InputController;
import lombok.AllArgsConstructor;
import com.project.pawtropoliss.map.MapController;
import com.project.pawtropoliss.player.domain.Bag;
import com.project.pawtropoliss.player.domain.Item;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DropActionStrategy implements ActionStrategy {

    private final Bag bag;
    private final MapController currentRoom;
    private final InputController inputController;

    @Autowired
    public DropActionStrategy(Bag bag, MapController currentRoom, InputController inputController) {
        this.bag = bag;
        this.currentRoom = currentRoom;
        this.inputController = inputController;
    }

    @Override
    public void execute() {
        if (bag.getItems().isEmpty()) {
            inputController.getInputString(" \n There are no items in the bag\n");
            return;
        }
        String itemName = inputController.getInputItemName("\n Which item do you want to drop? \n");
        Item item = bag.removeItemByName(itemName);
        if (itemName == null || itemName.equalsIgnoreCase("no") || itemName.equals("")) {
            inputController.getInputString(" \n You have not specified an item to drop \n");

            return;
        }
        if (item == null) {
            inputController.getInputString(" \n Item not found in the bag \n ");
            return;
        }
        if (!currentRoom.getCurrentRoom().addItemInTheRoom(item)) {
            bag.addItem(item);
        }
    }
}
