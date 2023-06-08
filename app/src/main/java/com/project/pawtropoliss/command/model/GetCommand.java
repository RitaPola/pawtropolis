package com.project.pawtropoliss.command.model;
import com.project.pawtropoliss.game.GameController;
import com.project.pawtropoliss.map.model.Room;
import com.project.pawtropoliss.player.model.Item;
import com.project.pawtropoliss.player.model.Player;
import org.springframework.stereotype.Component;

@Component
public class GetCommand extends ParameterCommand {

    public GetCommand(GameController gameController) {
        super ( gameController );
    }
    @Override
    public void execute() {
        String nameItem = getParameter ();
        Player player = getGameController ().getPlayer ();
        Room currentRoom = getGameController ().getMapController ().getCurrentRoom ();
        Item item = currentRoom.getItemByName ( nameItem );


        if (nameItem == null || nameItem.isEmpty ()) {
            System.out.println ( "Please specify the item you want to get" );
            return;
        }

        if (item == null) {
            System.out.println ( "Item not found" );
            return;
        }

        if (player.availableSlotsInBag ( item )) {
            player.addItemInTheBag ( item );
            currentRoom.removeItemInTheRoom ( item );
            System.out.println ( nameItem + " added to the bag" );
            System.out.println ( "\nThe room has been updated\n" + getGameController ().getMapController ().look () );
        } else {
            System.out.println ( "Not enough space in the bag" );
        }

    }
}