package gameStrategy;

import domain.Bag;
import domain.Item;
import domain.Player;

public class BagActionStrategy implements ActionStrategy {
    private Bag bag;

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
        System.out.println(itemList);
    }
}
