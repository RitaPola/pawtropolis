package com.project.pawtropoliss.map;

import com.project.pawtropoliss.player.utils.StringUtils;
import com.project.pawtropoliss.zoo.model.Animal;
import com.project.pawtropoliss.zoo.model.Eagle;
import com.project.pawtropoliss.zoo.model.Lion;
import com.project.pawtropoliss.zoo.model.Tiger;
import com.project.pawtropoliss.player.model.Item;
import com.project.pawtropoliss.map.model.Room;
import com.project.pawtropoliss.map.model.Direction;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class MapController {
    @Getter
    private Room currentRoom;
    public MapController() {
        this.currentRoom = createMap();

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
        System.out.println ("\n Welcome to pawtropolis \n" );
        Room entrance = new Room("entrance");
        Item item1 = Item.builder().name("walkie talkie").description("Necessary to hear a friend in distress or to ask for help").reqiuredSlots(4).build();
        entrance.addItemInTheRoom(item1);
        Animal birichino = Lion.builder().name("lion birichino").favoriteFood("meat").admissionDate(LocalDate.now()).weight(90.00).height(7.50).tailLength(3.5).build();
        entrance.addAnimalInTheRoom(birichino);

        Room kitchen = new Room("Kitchen");
        linkRooms(entrance, kitchen, Direction.NORTH);
        Item bana = Item.builder().name("banana").description("food").reqiuredSlots(1).build();
        kitchen.addItemInTheRoom(bana);
        Item aqua = Item.builder().name("aqua").description("drink").reqiuredSlots(3).build();
        kitchen.addItemInTheRoom(aqua);

        Room armory = new Room("Armory");
        linkRooms(kitchen, armory, Direction.SOUTH);
        Item Kal = Item.builder().name("Kalashnikov").description("mitragliatore").reqiuredSlots(6).build();
        armory.addItemInTheRoom(Kal);
        Item machete = Item.builder().name("machete").description("cutting weapon").reqiuredSlots(4).build();
        armory.addItemInTheRoom(machete);
        Animal wolf = Tiger.builder().name("Tiger wolf").favoriteFood("meat").admissionDate(LocalDate.now()).weight(75.00).height(5.00).tailLength(5.00).build();
        armory.addAnimalInTheRoom(wolf);

        Room nours = new Room("noursey");
        linkRooms(armory, nours, Direction.WEST);
        Animal eagleLaziale = Eagle.builder().name("Lazio merda").favoriteFood("meat").admissionDate(LocalDate.now()).weight(50.00).height(6.00).wingsLength(10.00).build();
        nours.addAnimalInTheRoom(eagleLaziale);
        Item medicalBandages = Item.builder().name("herbs").description("used to heal wounds").reqiuredSlots(1).build();
        nours.addItemInTheRoom(medicalBandages);
        Item herb = Item.builder().name("healing herb").description("Resident Evil style green herb").reqiuredSlots(3).build();
        nours.addItemInTheRoom(herb);
        return entrance;

    }

    public static void linkRooms(Room a, Room b, Direction directionA, Direction directionB) {
        a.addAdjacentRoom(b, directionA);
        b.addAdjacentRoom(a, directionB);
    }

    private static void linkRooms(Room a, Room b, Direction direction) {
        Direction directionB = switch (direction) {
            case NORTH -> Direction.SOUTH;
            case SOUTH -> Direction.NORTH;
            case EAST -> Direction.WEST;
            case WEST -> Direction.EAST;
            default -> Direction.INVALID;
        };
        linkRooms(a, b, direction, directionB);
    }
    public String look() {
        String itemsDescription = "[]";
        if (!getCurrentRoom().getItems().isEmpty()) {
            itemsDescription = StringUtils.getItemsListDescriptionString(getCurrentRoom().getItems());
        }

        String animalsDescription = "[]";
        if (!getCurrentRoom().getAnimals().isEmpty()) {
            animalsDescription = StringUtils.getAnimalsListDescriptionString(getCurrentRoom().getAnimals());
        }

        String doorsDescription = "[]";
        if (!getCurrentRoom().getAdjacentRooms().isEmpty()) {
            doorsDescription = StringUtils.getDirectionsListDescriptionString(new ArrayList<>(getCurrentRoom().getAdjacentRooms().keySet()));
        }

        return "Current room " + getCurrentRoom().getName() + ".\n" +
                "Items: " + itemsDescription + "\n" +
                "Animal: " + animalsDescription + "\n" +
                "Adjacent Room: " + doorsDescription;
    }
}
