package pawtropoliss.domain.command;

import lombok.AllArgsConstructor;
import pawtropoliss.domain.game.Bag;
import pawtropoliss.domain.game.Item;
@AllArgsConstructor
public class BagActionStrategy implements ActionStrategy {
    private Bag bag;

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
