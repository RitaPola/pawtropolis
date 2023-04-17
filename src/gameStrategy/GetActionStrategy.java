package gameStrategy;
import domain.Item;
import domain.Player;
import domain.Room;
public class GetActionStrategy implements ActionStrategy {
    private Room currentRoom;
    private String itemName;
    private Player player;

    public GetActionStrategy(Room currentRoom,String itemName, Player player) {
        this.itemName = itemName;
        this.player = player;
    }
    @Override
    public String execute() {
        if (player.getCurrentRoom().getItems().isEmpty()) {
            return "There are no items in the room";
        }
        if (itemName == null || itemName.equalsIgnoreCase("no") || itemName.equals("")) {
            return "You have not specified an item to get";
        }
        Item item = player.getCurrentRoom().removeItemByNameInTheRoom(itemName);
        if (item == null) {
            return "Item not found in the room";
        }
        try {
            if (player.getBag().getAvailableSlots() >= item.getOccupiedSlots()) { // Controllo della capacità massima della borsa
                player.addItemBag(item);
            } else {
                player.getCurrentRoom().addItemInTheRoom(item);
                return "Bag is full, cannot get the item";
            }
        } catch (IllegalArgumentException e) {
            player.getCurrentRoom().addItemInTheRoom(item);
            return "Item already exists in bag";
        } catch (IndexOutOfBoundsException e) {
            return "You have not specified an item to get";
        }
        return "Got " + item.getName() + " from the room and added it to your bag. ";
    }

}