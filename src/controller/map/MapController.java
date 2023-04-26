package controller.map;


import model.map.Direction;
import model.map.Room;

public class MapController {


    public static void linkRooms(Room a, Room b, Direction directionA, Direction directionB) {
        a.addAdjacentRoom(b, directionA);
        b.addAdjacentRoom(a, directionB);
    }

    public static void linkRooms(Room a, Room b, Direction direction) {
        Direction directionB = switch (direction) {
            case NORTH -> Direction.SOUTH;
            case SOUTH -> Direction.NORTH;
            case EAST -> Direction.WEST;
            case WEST -> Direction.EAST;
            default -> Direction.INVALID;
        };
        linkRooms(a, b, direction, directionB);
    }
}
