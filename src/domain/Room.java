package domain;

import gestionezoo.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room {

    private String name;
    private ArrayList <Item> items;
    private ArrayList<Animal> animals;
    private Map<String, Room> adjacentRooms;

    public Room(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjacentRooms = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public Map<String, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void setAdjacentRooms(Map<String, Room> adjacentRooms) {
        this.adjacentRooms = adjacentRooms;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public Room getAdjacentRoom(String direction) {
        return adjacentRooms.get(direction);
    }

    public void setAdjacentRoom(String direction, Room room) {
        adjacentRooms.put(direction, room);
    }





    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", items=" + items +
                ", animals=" + animals +
                ", adjacentRooms=" + adjacentRooms +
                '}';
    }
}
