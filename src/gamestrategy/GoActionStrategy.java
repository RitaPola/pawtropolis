package gameStrategy;

import mapcontroller.CreationMap;
import mapcontroller.Direction;
import domain.Player;
import mapcontroller.Room;

import java.util.Optional;

public class GoActionStrategy implements ActionStrategy {
    private Direction direction;


    public GoActionStrategy() {
        CreationMap map = new CreationMap();
    }
    @Override
    public void execute() {
        CreationMap map = new CreationMap();
        boolean isRoomChanged = map.changeRoom(direction);
        if (!isRoomChanged) {
            System.out.println("There's no room in that direction.");
        } else {
            Room nextRoom = map.getCurrentRoom();
            System.out.println(nextRoom.look());
        }
    }

}
