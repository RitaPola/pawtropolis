package gameStrategy;

import utils.StringUtils;
import domain.Direction;
import domain.Item;
import domain.Room;
import gestionezoo.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LookActionStrategy implements ActionStrategy{
    private Room room;
    public LookActionStrategy(Room room) {
        this.room = room;
    }
    @Override
    public String execute() {
        String itemsDescription = "{}";
        List<Item> items = room.getItems();
        if (!items.isEmpty()) {
            itemsDescription = StringUtils.getItemsListDescriptionString(items);
        }

        String animalsDescription = "{}";
        List<Animal> animals = room.getAnimals();
        if (!animals.isEmpty()) {
            animalsDescription = StringUtils.getAnimalsListDescriptionString(animals);
        }

        String doorsDescription = "{}";
        Map<Direction, Room> adjacentRooms = room.getAdjacentRooms();
        if (!adjacentRooms.isEmpty()) {
            doorsDescription = StringUtils.getDirectionsListDescriptionString(new ArrayList<>(adjacentRooms.keySet()));
        }

        return "Current room " + room.getName() + ".\n\n" +
                "Items: " + itemsDescription + "\n\n" +
                "Animals: " + animalsDescription + "\n\n" +
                "Adjacent Rooms: " + doorsDescription;
    }
}
