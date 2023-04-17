package domain;

import gestionezoo.Animal;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Objects;
import java.util.Optional;

public class Room {

    private String name;
    private ArrayList<Item> items;
    private ArrayList<Animal> animals;
    private EnumMap<Direction, Room> adjacentRooms;

    public Room() {
    }
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

    /*Aggiunge animale nella lista animali*/
    public Animal addAnimal(Animal animal) {
        if (animals.add(animal)) {
            return animal;
        }
        return null;
    }

    /*Rimuove animale dalla lista degli animali*/
    public Animal deleteAnimal(Animal animal) {
        if (animals.remove(animal)) {
            return animal;
        }
        return null;
    }

    /*Rimuove tutti gli animali dalla lista animale*/
    public void deleteAllAnimal() {
        animals.clear();
    }

    /*Ritorna gli animali della lista*/
    public ArrayList<Animal> ListAnimal() {
        return animals;
    }

    /*ricerca animale tramite nome*/
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
        for (Animal animalCurrent : animals) {
            if (animalCurrent.getName().toLowerCase().equals(nameToRemove)) {
                items.remove(animalCurrent);
                animal = animalCurrent;
                return animal;
            }
        }
        return null;
    }

    /*aggiunge un oggetto dentro la lista items*/
    public boolean addItem(Item item) {
        return items.add(item);
    }

    /*rimuove un oggetto dalla lista item*/
    public Item deleteItem(Item item) {
        if (items.remove(item)) {
            return item;
        }
        return null;
    }

    /*Rimuove tutti gli oggetti*/
    public void deleteAllItems() {
        items.clear();
    }

    /*ritorna lista oggetti*/
    public ArrayList<Item> ListItem() {
        return items;
    }

    /*Ricerca tramite nome dell'oggetto*/
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().toLowerCase().equals(name)) {
                return item;
            }
        }
        return null;
    }

    /*rimozione oggetto tramite nome*/
    public Item removeItemByName(String nameToRemove) {
        Item itm = items.get(0);
        for (Item itemCurrent : items) {
            if (itemCurrent.getName().toLowerCase().equals(nameToRemove)) {
                items.remove(itemCurrent);
                itm = itemCurrent;
                return itm;
            }
        }
        return null;
    }

    /*aggiunge la stanza nella lista corrente*/
    public Room addAdJacentRoom(Room room, Direction direction) {
        return adjacentRooms.put(direction, room);
    }

    /*Rimuove la stanza nella lista corrente in base alla stanza specifica*/
    public Room cancelAdjacentRoom(Room room) {
        if (adjacentRooms.values().remove(room)) {
            return room;
        } else {
            return null;
        }
    }

    /*restituzione di una stanza adiacente in base alla direzione specificata*/
    /*ho utilizzato l'optional elimina il rischio di avere un valore null inaspettato*/
    public Optional<Room> getAdjacentRoom(Direction direction) {
        return Optional.ofNullable(adjacentRooms.get(direction));
    }

    /*rimozione della stanza in base alla direzione specifica*/
    public Room cancelAdiacentRoom(Direction direction) {
        return adjacentRooms.remove(direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return name.equals(room.name) && items.equals(room.items) && animals.equals(room.animals) && adjacentRooms.equals(room.adjacentRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, items, animals, adjacentRooms);
    }

    /*IMP!!!! metodo look*/
    public String look() {
        String itemsDescription = "{}";
        if (!items.isEmpty()) {
            itemsDescription = Description.getItemsListDescriptionString(items);
        }

        String animalsDescription = "{}";
        if (!animals.isEmpty()) {
            animalsDescription = Description.getAnimalsListDescriptionString(animals);
        }

        String doorsDescription = "{}";
        if (!adjacentRooms.isEmpty()) {
            doorsDescription = Description.getDirectionsListDescriptionString(new ArrayList<>(adjacentRooms.keySet()));
        }

        return "Current room " + name + ".\n\n" +
                "Items: " + itemsDescription + "\n\n" +
                "Animal: " + animalsDescription + "\n\n" +
                "Adjacent Room: " + doorsDescription;
    }
}



