package pawtropoliss.utils;
import pawtropoliss.domain.mapmanager.Direction;
import pawtropoliss.domain.game.Item;
import pawtropoliss.domain.animal.Animal;
import java.util.List;

public class StringUtils {
    private StringUtils() {
    }

    public static String getItemsListDescriptionString(List<Item> items) {
        if (items.isEmpty()) {
            return "Empty";
        }

        String itemsDescription = "[";

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            itemsDescription += item.getName() + "(" + item.getOccupiedSlots() + ")";
            if (i < items.size() - 1) { /*Se l'oggetto corrente non è l'ultimo nella lista, il metodo aggiungerà una virgola */
                itemsDescription += ", ";
            }
        }

        itemsDescription += "]";
        return itemsDescription;
    }

    public static String getAnimalsListDescriptionString(List<Animal> animals) {
        if (animals.isEmpty()) {
            return "Empty";
        }

        String animalsDescription = "[";

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            animalsDescription += animal.getName();
            if (i < animals.size() - 1) {
                animalsDescription += ", ";
            }
        }
        animalsDescription += "]";
        return animalsDescription;
    }

    public static String getDirectionsListDescriptionString(List<Direction> directions) {
        if (directions.isEmpty()) {
            return "Empty";
        }
        String doorsDescription = "[";

        for (int i = 0; i < directions.size(); i++) {
            Direction direction = directions.get(i);
            doorsDescription += direction.getName();
            if (i < directions.size() - 1) {
                doorsDescription += ", ";
            }
        }

        doorsDescription += "]";
        return doorsDescription;
    }
}

