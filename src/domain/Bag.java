package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Bag {
    private List <Item>items;
    private int maxSlot;
    private final int totalSlots = 15;
    private int availableSlots;

    public Bag() {
        this.items = items;
        this.maxSlot=totalSlots;
        this.availableSlots=totalSlots;
        this.items=new ArrayList<>(totalSlots);
    }
    public Bag(int maxSlot){
        this.maxSlot=maxSlot;
        this.availableSlots=maxSlot;
        this.items=new ArrayList<>(totalSlots);
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

    public int getMaxSlot() {
        return maxSlot;
    }

    public void setMaxSlot(int maxSlot) {
        this.maxSlot = maxSlot;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    /*Inserimento e rimozione oggetto nella borsa*/
    public Item addItem(Item item) {
        if(items.add(item)){
            availableSlots -= item.getOccupiedSlots();
            return item;
        }
       return null;
    }
    public Item removeItem (Item item){
        if(items.remove(item)){
            availableSlots += item.getOccupiedSlots();
            return item;
        }
        return null;
    }
    /*Rimozione di tutti gli oggetti nella borsa*/
    public void clearAllItemList(){
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
    public void checkItemToBag(){
        final Logger LOGGER = Logger.getLogger("myLogger");
        if(items.isEmpty()){
            LOGGER.info("The bag is empty");
            //System.out.println("The bag is empty");
        }else{
           LOGGER.info("The items contained in the bag are: " + items);
        }
    }
    /* Rimozione tutti gli oggetti nella borsa */
    public void removeAllItemsBag(){
        items.clear();
    }
    /*Rimozione item tramite nome*/
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
    /*verifica quanti slot sono disponibili da controllare*/
    public void availableSlot(){
        final Logger LOGGER = Logger.getLogger("myLogger");
        if (items.isEmpty()){
            throw new IndexOutOfBoundsException("The list is empty");
        }else LOGGER.info("\n" +
                "The slots available are: " + availableSlots);
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
