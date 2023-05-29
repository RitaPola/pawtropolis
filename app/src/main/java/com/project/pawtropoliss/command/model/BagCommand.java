package com.project.pawtropoliss.command.model;
import com.project.pawtropoliss.game.GameController;
import com.project.pawtropoliss.player.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BagCommand extends Command {

    @Autowired
    public BagCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        List <Item> items = getGameController().getPlayer().getBag().getItems();
        int availableLots = getGameController().getPlayer().getBag().getAvailableSlots();
        String itemList = items.stream()
                .map(item -> item.getName() + " - " + item.getDescription())
                .collect(Collectors.joining(" - "));//unisce le stringhe con -
        if (!itemList.isEmpty()) {
            System.out.println("\n In the bag there is: " + itemList + ".\n");
        }
        System.out.println("\n You have " + availableLots + " available slots in your bag. \n");
    }
}
