package domain;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final List<Item> items;
    private static final int totalSlots = 15;/*n.tot di slot disponibili*/
    private int availableSlots;/*slot disponibili in base al numero di oggetti contenuti nella borsa*/
    private final int maxSlots;

    public Bag() {
        this.maxSlots=totalSlots;
        this.availableSlots=maxSlots;
        this.items=new ArrayList<>(maxSlots);
    }

    public Bag(int maxSlots) {
        this.maxSlots = maxSlots;
        this.availableSlots = maxSlots;
        this.items = new ArrayList<>(totalSlots);/* inizializzazione dell'arraylist di oggetti indica la max capacità*/
    }

    public List<Item> getItems() {
        return items;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    /*Inserimento e rimozione oggetto nella borsa*/
    public Item addItem(Item item) {
        if (availableSlots - item.getOccupiedSlots()>=0) {
            items.add(item);
            availableSlots -= item.getOccupiedSlots(); /*controllo dello spazio occupato da un oggetto, sottraggo gli slot disponibili - gli slot occupati dall oggetto */
            return item;
        }
        return null;
    }

    public Item removeItem(Item item) {
        if (items.remove(item)) {
            availableSlots += item.getOccupiedSlots();/*controllo di acquisizione dello spazio occupato da un oggetto*/
            return item;
        }
        return null;
    }

    /*Rimozione di tutti gli oggetti nella borsa*/
    public void clearAllItemList() {
        items.clear();
    }

    /*Ricerca un oggetto per nome*/
    public Item getItemByName(String name) {
       return items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);

    }

    /*verificare se ci sono oggetti nella borsa*/
    public String checkItemInTheBag() {
        String empty = "The bag is empty";
        String contained = "The items contained in the bag are: " + items;
        if (items.isEmpty()) {
            return empty;
        } else {
            return contained;
        }
    }

    /* Rimozione tutti gli oggetti nella borsa */
    public void removeAllItemsInTheBag() {
        items.clear();
    }

    /*Rimozione item tramite nome*/
    public Item removeItemByName(String nameToRemove) {
        return items.stream().filter(itemCurrent -> itemCurrent.getName().equalsIgnoreCase(nameToRemove))
                .findAny()
                .map(itemCurrent -> {
                    items.remove(itemCurrent);
                    availableSlots += itemCurrent.getOccupiedSlots();
                    return itemCurrent;
                })
                .orElse(null);
    }

    /*verifica quanti slot sono disponibili*/
    public int checkAvailableSlotInTheBag() {
        int slots = availableSlots;
        if (items.isEmpty()) {
            return 0;
        } else {
            return slots;
        }
    }

    /*ricerca oggetto per nome*/
    public Item searchItemByName(String nameItem) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(nameItem))
                .findAny()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Bag --> " +
                "items " + items +
                ", max slots " + maxSlots;
    }

}
