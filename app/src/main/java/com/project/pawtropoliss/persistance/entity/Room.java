package com.project.pawtropoliss.persistance.entity;

import com.project.pawtropoliss.persistance.entity.animals.Animal;
import lombok.*;
import java.util.*;

@Data
public class Room {

    private String name;

    private List<Item> items;

    private List<Animal> animals;

    private Map<Direction, Room> adjacentRooms;

    public Room(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjacentRooms = new EnumMap<>(Direction.class);
    }

    public void addAnimalInTheRoom(Animal animal) {
        animals.add(animal);
    }
    public Animal removeAnimalInTheRoom(Animal animal) {
        if (animals.remove(animal)) {
            return animal;
        }
        return null;

    }
    public void removeAllAnimalsInTheRoom() {
        animals.clear();
    }

    public List<Animal> getAllAnimalsInTheRoom() {
        return animals;
    }

    public Animal getAnimalByName(String nameAnimal) {
        return animals.stream().filter(animal -> animal.getName().toLowerCase().equalsIgnoreCase(nameAnimal))
                .findAny()
                .orElse(null);
    }

    public Animal removeAnimalByName(String nameToRemove) {
        return animals.stream().filter(animalCurrent -> animalCurrent.getName().toLowerCase().equalsIgnoreCase(nameToRemove))
                .findAny()
                .map(animalCurrent -> {
                    animals.remove(animalCurrent);
                    return animalCurrent;
                }).orElse(null);
    }

    public boolean addItemInTheRoom(Item item) {
        if (item == null) {
            return false;
        }
        if (items.contains(item)) {
            return false;
        }
        items.add(item);
        return true;
    }
    public void removeItemInTheRoom(Item item) {
        items.remove ( item );
    }
    public void deleteAllItems() {
        items.clear();
    }

    public List<Item> getAllItems() {
        return items;
    }

    public Item getItemByName(String name) {
        return items.stream()
                .filter(item -> item.getName().toLowerCase().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }
    public Item removeItemByName(String nameToRemove) {
        return items.stream().filter(itemCurrent -> itemCurrent.getName().toLowerCase().equalsIgnoreCase(nameToRemove))
                .findAny()
                .map(itemCurrent -> {
                    items.remove(itemCurrent);
                    return itemCurrent;
                }).orElse(null);
    }

    public void addAdjacentRoom(Room room, Direction direction) {
        adjacentRooms.put(direction, room);
    }

    public Room cancelAdjacentRoom(Room room) {
        if (adjacentRooms.values().remove(room)) {
            return room;
        } else {
            return null;
        }
    }
    public Room getAdjacentRoomDirection(Direction direction) {
        return adjacentRooms.get(direction);
    }

    public Room cancelAdjacentRoomDirection(Direction direction) {
        return adjacentRooms.remove(direction);
    }

}



