package com.project.pawtropoliss.command.model;
import com.project.pawtropoliss.game.GameController;
import com.project.pawtropoliss.map.model.Room;
import com.project.pawtropoliss.player.model.Item;
import com.project.pawtropoliss.player.model.Player;
import org.springframework.stereotype.Component;

@Component
public class GetCommand extends Command {

    public GetCommand(GameController gameController) {
        super(gameController);
    }


    @Override
    public void execute() {
        String nameItem = ParameterCommand.getParameter();
        Player player = getGameController().getPlayer();
        Room currentRoom = getGameController().getMapController().getCurrentRoom();
        Item item = currentRoom.getItemByName(nameItem);
        if (item == null) {
            System.out.println("Item not present in current room");
        } else {
            if (player.availableSlotsInBag(item)) {
                player.addItemInTheBag(item);
                currentRoom.removeItemInTheRoom(item);
                System.out.println (nameItem +" added to the bag");
            } else {
                System.out.println("Not enough space in bag");
            }
        }
    }
}
