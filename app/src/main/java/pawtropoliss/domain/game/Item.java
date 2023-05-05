package pawtropoliss.domain.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {

    private String name;
    private String description;
    private int occupiedSlots; /*slot occupati dall'oggetto nella borsa - rinominarlo in requiredSlots*/

    @Override
    public String toString() {
        return "Item: " +
                "nameItem: " + name + '\'' +
                ", description: " + description + '\'' +
                ", occupiedSlots: " + occupiedSlots;
    }

}
