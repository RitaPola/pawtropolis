package gamestrategy;

import model.map.Direction;
import model.map.MapCreator;
import model.map.Room;

public class GoActionStrategy implements ActionStrategy {
    private final Direction direction;
    private final MapCreator map;

    public GoActionStrategy(MapCreator map, Direction direction) {
        this.map = map;
        this.direction = direction;
    }

    @Override
    public void execute() {
        boolean isRoomChanged = map.changeRoom(direction);
        if (!isRoomChanged) {
            System.out.println("There's no room in that direction.");
        } else {
            Room nextRoom = map.getCurrentRoom();
            System.out.println(nextRoom.look());
        }
    }
}
