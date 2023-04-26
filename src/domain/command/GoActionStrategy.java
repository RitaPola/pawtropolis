package domain.command;

import domain.mapmanager.Direction;
import controller.map.MapController;
import domain.game.Room;

public class GoActionStrategy implements ActionStrategy {
    private final Direction direction;
    private final MapController map;

    public GoActionStrategy(MapController map, Direction direction) {
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
