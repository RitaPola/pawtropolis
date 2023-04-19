package mapcontroller;

import domain.Item;
import gestionezoo.Animal;
import utils.StringUtils;

import java.util.*;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Map<Direction, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void setAdjacentRooms(Map<Direction, Room> adjacentRooms) {
        this.adjacentRooms = adjacentRooms;
    }

    /*Aggiunge animale nella lista animali*/
    public void addAnimalInTheRoom(Animal animal) {
        animals.add(animal);
    }

    /*Rimuove animale dalla lista degli animali*/
    public Animal removeAnimalInTheRoom(Animal animal) {
        if (animals.remove(animal)) {
            return animal;
        }
        return null;
    }

    /*Rimuove tutti gli animali dalla lista animale*/
    public void removeAllAnimalInTheRoom() {
        animals.clear();
    }

    /*Ritorna gli animali della lista*/
    public List<Animal> getAllAnimalInTheRoom() {
        return animals;
    }

    /*ricerca animale tramite nome*/
    public Animal getAnimalByNameInTheRoom(String nameAnimal) {
        return animals.stream().filter(animal -> animal.getName().toLowerCase().equalsIgnoreCase(nameAnimal))
                .findAny()
                .orElse(null);
    }

    /*rimozione animale tramite nome*/
    public Animal removeAnimalByNameInTheRoom(String nameToRemove) {
        return animals.stream().filter(animalCurrent -> animalCurrent.getName().toLowerCase().equalsIgnoreCase(nameToRemove))
                .findAny()
                .map(animalCurrent -> {
                    animals.remove(animalCurrent);
                    return animalCurrent;
                }).orElse(null);
    }

    /*aggiunge un oggetto dentro la lista items*/
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

    /*rimuove un oggetto dalla lista item*/
    public Item removeItemInTheRoom(Item item) {
        if (items.remove(item)) {
            return item;
        }
        return null;
    }

    /*Rimuove tutti gli oggetti*/
    public void deleteAllItems() {
        items.clear();
    }

    /*ritorna lista di oggetti*/
    public List<Item> getAllItems() {
        return items;
    }

    /*Ricerca tramite nome dell'oggetto*/
    public Item getItemByNameInTheRoom(String name) {
        return items.stream()
                .filter(item -> item.getName().toLowerCase().equalsIgnoreCase(name))
                .findAny()            /*viene utilizzato per cercare un elemento qualsiasi in un flusso di dati (stream). Restituisce un Optional che rappresenta l'elemento trovato*/
                .orElse(null); /*utilizzata negli stream come fallback o valore predefinito nel caso in cui il risultato dello stream sia vuoto (empty)*/
    }

    /*rimozione oggetto tramite nome*/
    public Item removeItemByNameInTheRoom(String nameToRemove) {
        return items.stream().filter(itemCurrent -> itemCurrent.getName().toLowerCase().equalsIgnoreCase(nameToRemove))
                .findAny()
                .map(itemCurrent -> {
                    items.remove(itemCurrent);
                    return itemCurrent;
                }).orElse(null);
    }

    /*aggiunge la stanza nella lista corrente*/
    public void addAdjacentRoom(Room room, Direction direction) {
        adjacentRooms.put(direction, room);
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
    public Room getAdjacentRoomDirection(Direction direction) {
        return adjacentRooms.get(direction);
    }


    /*rimozione della stanza in base alla direzione specifica*/
    public Room cancelAdjacentRoomDirection(Direction direction) {
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

    /*metodo look*/
    public String look() {
        String itemsDescription = "{}";
        if (!items.isEmpty()) {
            itemsDescription = StringUtils.getItemsListDescriptionString(items);
        }

        String animalsDescription = "{}";
        if (!animals.isEmpty()) {
            animalsDescription = StringUtils.getAnimalsListDescriptionString(animals);
        }

        String doorsDescription = "{}";
        if (!adjacentRooms.isEmpty()) {
            doorsDescription = StringUtils.getDirectionsListDescriptionString(new ArrayList<>(adjacentRooms.keySet()));
        }

        return "Current room " + name + ".\n\n" +
                "Items: " + itemsDescription + "\n\n" +
                "Animal: " + animalsDescription + "\n\n" +
                "Adjacent Room: " + doorsDescription;
    }


}



