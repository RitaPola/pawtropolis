package com.project.pawtropoliss.command.service;
import com.project.pawtropoliss.map.MapController;
import com.project.pawtropoliss.player.domain.Item;
import com.project.pawtropoliss.player.domain.Player;
import com.project.pawtropoliss.map.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class GetActionStrategy implements ActionStrategy {



    private final Player player;
    private final MapController map;

    private Item itemName;
    public void setItem(Item itemName) {
        this.itemName = itemName;
    }
    @Autowired
    public GetActionStrategy(Player player, MapController map) {
        this.player = player;
        this.map = map;
    }
    @Override
    public void execute() {
        Room currentRoom = map.getCurrentRoom();
        if (currentRoom.getItems().isEmpty()) {
            System.out.println("\n There are no items in the room \n");
            return;
        }

        if (itemName.getName() == null || itemName.getName().isEmpty()) {
            System.out.println("\n You have not specified an item to get \n");
            return;
        }

        Item item = currentRoom.removeItemByNameInTheRoom(itemName.getName());
        if (item == null) {
            System.out.println("\n Item not found in the room \n");
            return;
        }

        if (player.getBagPlayer().getAvailableSlots() >= item.getOccupiedSlots()) {
            try {
                player.addItemInTheBagPlayerBag(item);
                System.out.println("\n Got " + item.getName() + " from the room and added it to your bag. \n");
            } catch (IllegalArgumentException e) {
                currentRoom.addItemInTheRoom(item);
                System.out.println("\n Item already exists in bag \n");
            }
        } else {
            currentRoom.addItemInTheRoom(item);
            System.out.println("\n Bag is full, cannot get the item \n");
        }
    }

}
