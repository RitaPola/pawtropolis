package gamestrategy;

import model.map.MapCreator;
import domain.player.Bag;
import domain.player.Item;

public class DropActionStrategy implements ActionStrategy{
    private final Bag bag;
    private final String itemName;
    private final MapCreator currentRoom;
    public DropActionStrategy(Bag bag, String itemName, MapCreator currentRoom) {
        this.bag = bag;
        this.itemName = itemName;
        this.currentRoom = currentRoom;
    }
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
