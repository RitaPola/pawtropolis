package com.project.pawtropoliss.command.model;

import com.project.pawtropoliss.game.GameController;
import com.project.pawtropoliss.player.model.Item;
import com.project.pawtropoliss.player.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DropCommand extends Command {

    @Autowired
    public DropCommand(GameController gameController) {
       super(gameController);
    }
    @Override
    public void execute() {
        String nameItem = ParameterCommand.getParameter();
        Player player = getGameController().getPlayer();
        Item item = player.getBag().getItemByName(nameItem);
        if (item == null) {
            System.out.println("Item not present in bag");
        } else {
            player.removeItemFromTheBag(item);
            getGameController().getMapController().getCurrentRoom().addItemInTheRoom(item);
            System.out.println (nameItem + " dropped in the room");
        }
    }
}
