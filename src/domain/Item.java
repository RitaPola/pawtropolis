package domain;

public class Item {

    private String nameItem;
    private String description;
    private int occupiedSlots;

    public Item(String nameItem, String description, int occupiedSlots) {
        this.nameItem = nameItem;
        this.description = description;
        this.occupiedSlots = occupiedSlots;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOccupiedSlots() {
        return occupiedSlots;
    }

    public void setOccupiedSlots(int occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }

    @Override
    public String toString() {
        return "Item --> " +
                "nameItem='" + nameItem + '\'' +
                ", description='" + description + '\'' +
                ", occupiedSlots=" + occupiedSlots;
    }

}
