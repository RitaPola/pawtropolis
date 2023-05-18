package com.project.pawtropoliss.map;

import com.project.pawtropoliss.zoo.domain.Animal;
import com.project.pawtropoliss.zoo.domain.Eagle;
import com.project.pawtropoliss.zoo.domain.Lion;
import com.project.pawtropoliss.zoo.domain.Tiger;
import com.project.pawtropoliss.player.domain.Item;
import com.project.pawtropoliss.map.model.Room;
import com.project.pawtropoliss.map.model.Direction;
import lombok.Getter;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

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
        Room entrance = new Room("entrance");
        Item item1 = Item.builder().name("walkie talkie").description("Necessary to hear a friend in distress or to ask for help").occupiedSlots(4).build();
        entrance.addItemInTheRoom(item1);
        Animal birichino = Lion.builder().name("lion birichino").favoriteFood("meat").admissionDate(LocalDate.now()).weight(90.00).height(7.50).tailLength(3.5).build();
        entrance.addAnimalInTheRoom(birichino);
        Room kitchen = new Room("Kitchen");
        linkRooms(entrance, kitchen, Direction.NORTH);
        Item bana = Item.builder().name("banana").description("food").occupiedSlots(1).build();
        kitchen.addItemInTheRoom(bana);
        Item aqua = Item.builder().name("aqua").description("drink").occupiedSlots(3).build();
        kitchen.addItemInTheRoom(aqua);
        Room armory = new Room("Armory");
        linkRooms(kitchen, armory, Direction.SOUTH);
        Item Kal = Item.builder().name("Kalashnikov").description("mitragliatore").occupiedSlots(6).build();
        armory.addItemInTheRoom(Kal);
        Item machete = Item.builder().name("machete").description("cutting weapon").occupiedSlots(4).build();
        armory.addItemInTheRoom(machete);
        Animal wolf = Tiger.builder().name("Tiger wolf").favoriteFood("meat").admissionDate(LocalDate.now()).weight(75.00).height(5.00).tailLength(5.00).build();
        armory.addAnimalInTheRoom(wolf);
        Room nours = new Room("noursey");
        linkRooms(armory, nours, Direction.WEST);
        Animal eagleLaziale = Eagle.builder().name("Lazio merda").favoriteFood("meat").admissionDate(LocalDate.now()).weight(50.00).height(6.00).wingsLength(10.00).build();
        nours.addAnimalInTheRoom(eagleLaziale);
        Item medicalBandages = Item.builder().name("herbs").description("used to heal wounds").occupiedSlots(1).build();
        nours.addItemInTheRoom(medicalBandages);
        Item herb = Item.builder().name("healing herb").description("Resident Evil style green herb").occupiedSlots(3).build();
        nours.addItemInTheRoom(herb);
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
