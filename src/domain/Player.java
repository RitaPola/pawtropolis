package domain;

import java.util.Optional;
import java.util.logging.Logger;


public class Player {
    private String name;
    private int health;
    private Bag bag;
    private Room currentRoom;

    public Player(String name, int health, Bag bag, Room currentRoom) {
        this.name = name;
        this.health = health;
        this.bag = bag;
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /*aggiunge un oggetto nello zaino del giocatore*/
    public Item addItemBag(Item item) {
        if (bag == null) {
            throw new IllegalStateException("bag field is null");
        }
        try {
            return bag.addItem(item);
        } catch (IllegalStateException e) {
            System.out.println("bag is full");
        } catch (IllegalArgumentException e) {
            System.out.println("item already exists in bag");
        }
        return item;
    }

    /*rimozione oggetto dallo zaino del giocatore*/
    public Item removeItemBag(Item item) {
        return bag.removeItem(item);
    }

    /*rimozione dell'oggetto tramite nome*/
    public Item removeItemBagByName(String nameItem) {
        return bag.removeItemByName(nameItem);
    }

    /*rimuove tutti oggetti dallo zaino del giocatore*/
    public void removeallItemBag() {
        bag.removeAllItemsBag();
    }

    /*Ricerca oggetto per nome*/
    public Item serachItemByName(String nameItem) {
        return bag.searchItemByName(nameItem);
    }

    /*incrementa la vita del giocatore*/
    public void increaseLifePoints(int point) {
        if (point <= 0) {
            throw new IllegalArgumentException("The life point must be a positive integer");
        }
        int newLifePoints = Math.min(health + point, 100);
        health = newLifePoints;
    }

    /*verifica gli slot disponibili nella borsa*/
    public void availableSlotTobag() {
        bag.availableSlot();
    }

    /*Decrementa la vita del giocatore*/
    public void decreaseLifePoints(int point) {
        Logger LOGGER = Logger.getLogger("myLogger");
        if (point <= 0) {
            throw new IllegalArgumentException("The life point must be a positive integer");
        }
        int newLifePoints = Math.max(health - point, 0);
        health = newLifePoints;
        if (health == 0) {
            LOGGER.info("Player is dead");
        }
    }

    /*verifica se il player è vivo*/
    public boolean isAlive() {
        return health > 0;
    }

    /*IMP!!!! metodo go*/
    public String go(Player player, Direction direction) {
        Room adjacentRoom = null;
        String trueParameter = "You are ";
        String falseParameter = "There is no room in that direction ";
        Optional<Room> adjacentRoomOptional = player.getCurrentRoom().getAdjacentRoom(direction);
        if (adjacentRoomOptional.isPresent()) {
            adjacentRoom = adjacentRoomOptional.get();
            player.setCurrentRoom(adjacentRoom);
            return trueParameter + adjacentRoom.look();
        } else {
            return falseParameter;
        }
    }

    /*IMP!!! Elenca il contenuto della borsa del giocatore*/
    public String getItemsInThePlayerBag() {
        String itemList = " ";
        if (bag.getItems().isEmpty()) {
            itemList += "empty";
        } else {
            for (Item item : bag.getItems()) {
                itemList += item.getNameItem() + ", ";
            }
            itemList = itemList.substring(0, itemList.length() - 2); // remove the trailing comma and space
        }
        return itemList;
    }

    /*Aggiunge alla borsa del giocatore l'item specificato come parametro (nome dell'item) e lo rimuove dalla stanza.*/
    public String get(String itemName) {
        if (currentRoom.getItems().isEmpty()) {
            return "There are no items in the room";
        }
        if (itemName == null || itemName.equals("no") || itemName.equals("")) {
            return "You have not specified an item to get";
        }
        Item item = currentRoom.removeItemByName(itemName);
        if (item == null) {
            return "Item not found in the room";
        }
        try {
            addItemBag(item);
        } catch (IllegalStateException e) {
            currentRoom.addItem(item);
            return "Bag is full, cannot get the item";
        } catch (IllegalArgumentException e) {
            currentRoom.addItem(item);
            return "Item already exists in bag";
        } catch (IndexOutOfBoundsException e) {
            return "You have not specified an item to get";
        }
        return "Got " + item.getNameItem() + " from the room and added it to your bag.";
    }

    /*IMP!! metodo drop*/
    public String drop(String itemName) {
        if (bag.getItems().isEmpty()) {
            return "There are no items in the bag";
        }
        Item item = bag.removeItemByName(itemName);
        if (itemName == null || itemName.toLowerCase().equals("no") || itemName.equals("")) {
            return "You have not specified an item to drop";
        }
        if (item == null) {
            return "Item not found in the bag";
        }
        try {
            currentRoom.addItem(item);
        } catch (IllegalStateException e) {
            bag.addItem(item);
            return "Room is full, cannot drop the item";
        } catch (IllegalArgumentException e) {
            bag.addItem(item);
            return "Item already exists in room";
        } catch (IndexOutOfBoundsException e) {
            return "You have not deleted any items";
        }
        return "Dropped " + item.getNameItem() + " from the bag in the room.";
    }

    @Override
    public String toString() {
        return "Player --> " +
                "name " + name + '\'' +
                ", health " + health +
                ", bag " + bag;

    }


}
