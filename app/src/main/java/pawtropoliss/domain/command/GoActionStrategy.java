package pawtropoliss.domain.command;

import lombok.AllArgsConstructor;
import pawtropoliss.controller.map.MapController;
import pawtropoliss.domain.mapmanager.Direction;

import pawtropoliss.domain.game.Room;
@AllArgsConstructor
public class GoActionStrategy implements ActionStrategy {
    private final MapController map;
    private final Direction direction;

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
