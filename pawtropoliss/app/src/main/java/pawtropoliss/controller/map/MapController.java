package pawtropoliss.controller.map;

import pawtropoliss.domain.animal.Animal;
import pawtropoliss.domain.mapmanager.Direction;
import pawtropoliss.domain.game.Room;
import pawtropoliss.domain.game.Item;
import java.time.LocalDate;


public class MapController {

    private Room currentRoom;

    public MapController() {
        this.currentRoom = createMap();
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean changeRoom(Direction direction) {
        Room nextRoom = currentRoom.getAdjacentRoomDirection(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        }
        return false;
    }

    private static Room createMap() {
        Room entrance = new Room("entrance");
        entrance.addItemInTheRoom(new Item("walkie talkie", "Necessary to hear a friend in distress or to ask for help", 4));
        entrance.addAnimalInTheRoom(new Animal("Lion Biricchino", "meat", LocalDate.now(), 90.00, 7.50));
        Room kitchen = new Room("Kitchen");
        linkRooms(entrance, kitchen, Direction.NORTH);
        kitchen.addItemInTheRoom(new Item("banana", "food", 1));
        kitchen.addItemInTheRoom(new Item("aqua", "water", 1));
        Room armory = new Room("Armory");
        linkRooms(kitchen, armory, Direction.SOUTH);
        armory.addItemInTheRoom(new Item("Kalashnikov", "mitragliatore", 6));
        armory.addItemInTheRoom(new Item("machete", "cutting weapon", 4));
        armory.addAnimalInTheRoom(new Animal("Tiger wolf", "meat", LocalDate.now(), 80.00, 6.50));
        Room noursey = new Room("Noursey");
        linkRooms(armory,noursey, Direction.WEST);
        noursey.addAnimalInTheRoom(new Animal("Eagle Pincopallino", "meat", LocalDate.now(), 30.00, 2.50));
        noursey.addItemInTheRoom(new Item("medical bandages", "they are used to bandage wounds", 1));
        noursey.addItemInTheRoom(new Item("healing herb", "Resident Evil style green herb", 3));
        return entrance;
    }

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
