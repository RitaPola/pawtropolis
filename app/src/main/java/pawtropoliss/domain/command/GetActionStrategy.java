package pawtropoliss.domain.command;
import lombok.AllArgsConstructor;
import pawtropoliss.controller.map.MapController;
import pawtropoliss.domain.game.Item;
import pawtropoliss.domain.game.Player;
import pawtropoliss.domain.game.Room;

@AllArgsConstructor
public class GetActionStrategy implements ActionStrategy {

        private final String itemName;
        private final Player player;
        private final MapController map;

        @Override
        public void execute() {
            Room currentRoom = map.getCurrentRoom();
            if (currentRoom.getItems().isEmpty()) {
                System.out.println("There are no items in the room");
                return;
            }
            if (itemName == null || itemName.equalsIgnoreCase("no") || itemName.equals("")) {
                System.out.println("You have not specified an item to get");
                return;
            }
            Item item = currentRoom.removeItemByNameInTheRoom(itemName);
            if (item == null) {
                System.out.println("Item not found in the room");
                return;
            }
            if (player.getBagPlayer().getAvailableSlots() >= item.getOccupiedSlots()) { // Controllo della capacità massima della borsa
                try {
                    player.addItemInTheBagPlayerBag(item);
                } catch (IllegalArgumentException e) {
                    currentRoom.addItemInTheRoom(item);
                    System.out.println("Item already exists in bag");
                    return;
                }
                System.out.println("Got " + item.getName() + " from the room and added it to your bag. ");
            } else {
                currentRoom.addItemInTheRoom(item);
                System.out.println("Bag is full, cannot get the item");
            }
        }
    }
