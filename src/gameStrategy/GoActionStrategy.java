package gameStrategy;

import mapcontroller.CreationMap;
import mapcontroller.Direction;
import domain.Room;

import java.util.Optional;

public class GoActionStrategy implements ActionStrategy {
    private Direction direction;

    private final CreationMap map;


    public GoActionStrategy(CreationMap map, Direction direction) {
       this.map = map;
       this.direction = direction;
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
