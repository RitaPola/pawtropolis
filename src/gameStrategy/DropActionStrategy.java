package gameStrategy;

import domain.Bag;
import domain.Item;
import domain.Room;

public class DropActionStrategy implements ActionStrategy{
    private Bag bag;
    private String itemName;
    private Room currentRoom;
    public DropActionStrategy(Bag bag, String itemName, Room currentRoom) {
        this.bag = bag;
        this.itemName = itemName;
        this.currentRoom = currentRoom;
    }
    @Override
    public String execute() {
        if (bag.getItems().isEmpty()) {
            return "There are no items in the bag";
        }
        Item item = bag.removeItemByName(itemName);
        if (itemName == null || itemName.equalsIgnoreCase("no") || itemName.equals("")) {
            return "You have not specified an item to drop";
        }
        if (item == null) {
            return "Item not found in the bag";
        }
        try {
            currentRoom.addItem(item);
        } catch (IllegalStateException e) {
            bag.addItem(item);
            return "Room is full, cannot drop the item";
        } catch (IllegalArgumentException e) {
            bag.addItem(item);
            return "Item already exists in room";
        } catch (IndexOutOfBoundsException e) {
            return "You have not deleted any items";
        }
        return "Dropped " + item.getNameItem() + " from the bag in the room. ";
    }
}
