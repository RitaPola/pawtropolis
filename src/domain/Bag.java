package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Bag {
    private List<Item> items;
    private final int totalSlots = 15;/*n.tot di slot disponibili*/
    private int availableSlots;/*slot disponibili in base al numero di oggetti contenuti nella borsa*/

    public Bag() {
        this.items = items;
        this.availableSlots = totalSlots;
        this.items = new ArrayList<>(totalSlots);/* inizializzazione dell'arraylist di oggetti indica la max capacità*/
    }
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    /*Inserimento e rimozione oggetto nella borsa*/
    public Item addItem(Item item) {
        if (items.add(item)) {
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
        for (Item item : items) {
            if (item.getNameItem().toLowerCase().equals(name)) {
                return item;
            }
        }
        return null;
    }
    /*verificare se ci sono oggetti nella borsa*/
    public String checkItemToBag() {
        String empty = "The bag is empty";
        String contained = "The items contained in the bag are: " + items;
        if (items.isEmpty()) {
            return empty;
        } else {
            return contained;
        }
    }
    /* Rimozione tutti gli oggetti nella borsa */
    public void removeAllItemsBag() {
        items.clear();
    }
    /*Rimozione item tramite nome*/
    public Item removeItemByName(String nameToRemove) {
        Item itm = items.get(0);
        for (Item itemCurrent : items) {
            if (itemCurrent.getNameItem().equals(nameToRemove)) {
                items.remove(itemCurrent);
                itm = itemCurrent;
                return itm;
            }
        }
        return null;
    }
    /*verifica quanti slot sono disponibili*/
    public String availableSlot() {
        if (items.isEmpty()) {
            return "The list is empty";
        } else {
            return "The slots available are: " + availableSlots;
        }
    }

    /*ricerca oggetto per nome*/
    public Item searchItemByName(String nameItem) {
        for (Item item : items) {
            if (item.getNameItem().toLowerCase().equals(nameItem)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Bag --> " +
                "items " + items +
                ", totalSlots " + totalSlots;
    }

}
