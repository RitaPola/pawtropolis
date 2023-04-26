package domain.player;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final List<Item> items;
    private static final  int totalSlots = 15;/*n.tot di slot disponibili*/
    private int availableSlots;/*slot disponibili in base al numero di oggetti contenuti nella borsa*/
    private final int maxSlots; /* indica il numero massimo di oggetti che la borsa può contenere*/

    public Bag() {
        this.maxSlots = totalSlots;
        this.availableSlots = maxSlots;
        this.items = new ArrayList<>(maxSlots);
    }
    public Bag(int maxSlot) {
        this.maxSlots = maxSlot;
        this.availableSlots = maxSlot;
        this.items = new ArrayList<>(maxSlot);
    }

    public List<Item> getItems() {
        return items;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    /*Inserimento e rimozione oggetto nella borsa*/
    public Item addItem(Item item) {
        if (availableSlots - item.getOccupiedSlots() >= 0) {//controllo degli oggetti che possono essere inseriti
            items.add(item);
            availableSlots -= item.getOccupiedSlots();
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
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findAny()            /*viene utilizzato per cercare un elemento qualsiasi in un flusso di dati (stream). Restituisce un Optional che rappresenta l'elemento trovato*/
                .orElse(null); /*utilizzata negli stream come fallback o valore predefinito nel caso in cui il risultato dello stream sia vuoto (empty)*/

    }
    /*verificare se ci sono oggetti nella borsa*/
    public int checkItemsInTheBag() {
        if (items.isEmpty()) {
            return 0;
        }
        return items.size();
    }
    /* Rimozione tutti gli oggetti nella borsa */
    public void removeAllItemFromTheBag() {
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
                }).orElse(null);
    }

    /*verifica quanti slot sono disponibili*/
    public int checkAvailableSlotsInTheBag() {
        int slots = availableSlots;
        if (items.isEmpty()) {
            return 0;
        } else {
            return slots;
        }
    }

    @Override
    public String toString() {
        return "Bag  ----> " +
                "items: " + items +
                ", available slots: " + maxSlots;
    }
}
