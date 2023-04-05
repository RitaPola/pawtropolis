package domain;

import gestionezoo.Animal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EnumMap;

public class Room {

    private String name;
    private ArrayList <Item> items;
    private ArrayList<Animal> animals;
    private EnumMap<Direction, Room> adjacentRooms;

    public Room(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjacentRooms = new EnumMap<>(Direction.class);
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

    public EnumMap<Direction, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void setAdjacentRooms(EnumMap<Direction, Room> adjacentRooms) {
        this.adjacentRooms = adjacentRooms;
    }

    public Animal addAnimal(Animal animal) {
        if(animals.add(animal)){
            return animal;
        }
        return null;
    }
    public Animal deleteAnimal(Animal animal) {
        if(animals.remove(animal)){
            return animal;
        }
        return null;
    }
    public void deleteAllAnimal(){
         animals.clear();
    }
    public ArrayList<Animal> ListAnimal(){
        return animals;
    }
    public Animal getAnimalByName(String nameAnimal) {
        for (Animal animal : animals) {
            if (animal.getName().toLowerCase().equals(nameAnimal)) {
                return animal;
            }
        }
        return null;
    }
    /*rimozione animale tramite nome*/
    public Animal removeAnimalByName(String nameToRemove) {
       Animal animal = animals.get(0);
        for(Animal animalCurrent : animals) {
            if (animalCurrent.getName().equals(nameToRemove)) {
                items.remove(animalCurrent);
                animal = animalCurrent;
                return animal;
            }
        }
        return null;
    }
    public Item addItem(Item item) {
        if(items.add(item)){
            return item;
        }
        return null;
    }
    public Item deleteItem(Item item) {
        if(items.remove(item)){
            return item;
        }
        return null;
    }
    public void deleteAllItems(){
       items.clear();
    }
    /*return lista oggetti*/
    public ArrayList<Item> ListItem(){
        return items;
    }
    /*Ricerca tramite nome dell'oggetto*/
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getNameItem().toLowerCase().equals(name)) {
                return item;
            }
        }
        return null;
    }
    /*rimozione oggetto tramite nome*/
    public Item removeItemByName(String nameToRemove) {
        Item itm = items.get(0);
        for(Item itemCurrent : items) {
            if (itemCurrent.getNameItem().equals(nameToRemove)) {
                items.remove(itemCurrent);
                itm = itemCurrent;
                return itm;
            }
        }
        return null;
    }
    /*aggiunge le stanze dentro enum map*/
    public Room addAdJacentRoom(Direction direction, Room room){
        return adjacentRooms.put(direction,room);
    }
    public Room deleteAdjacentRoom(Room room){
         return adjacentRooms.remove(room);
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
