package gameStrategy;

import domain.Direction;
import domain.Player;
import domain.Room;

import java.util.Optional;

public class GoActionStrategy implements ActionStrategy{
    private Player player;
    private Direction direction;
    private Room adjacentRoom;
    public GoActionStrategy(Player player,Direction direction){
        this.player=player;
        this.direction=direction;
    }
    @Override
    public String execute() {
        String trueParameter = "You are ";
        String falseParameter = "There is no room in that direction ";
        Optional<Room> adjacentRoomOptional = player.getCurrentRoom().getAdjacentRoom(direction);
        if (adjacentRoomOptional.isPresent()) {
            adjacentRoom = adjacentRoomOptional.get();
            player.setCurrentRoom(adjacentRoom);
            return trueParameter + adjacentRoom.look();
        } else {
            return falseParameter;
        }
    }
}
