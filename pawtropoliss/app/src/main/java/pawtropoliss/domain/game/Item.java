package pawtropoliss.domain.game;

public class Item {

    private String name;
    private String description;

    private int occupiedSlots; /*slot occupati dall'oggetto nella borsa - rinominarlo in requiredSlots*/

    public Item(String name, String description, int occupiedSlots) {
        this.name = name;
        this.description = description;
        this.occupiedSlots = occupiedSlots;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameItem) {
        this.name = nameItem;
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
                "nameItem: " + name + '\'' +
                ", description: " + description + '\'' +
                ", occupiedSlots: " + occupiedSlots;
    }

}
