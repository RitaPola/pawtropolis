package com.project.pawtropoliss.player.utils;

import com.project.pawtropoliss.zoo.domain.Animal;
import com.project.pawtropoliss.player.domain.Item;
import com.project.pawtropoliss.map.model.Direction;

import java.util.List;

public class StringUtils {
    private StringUtils() {
    }

    public static String getItemsListDescriptionString(List<Item> items) {
        if (items.isEmpty()) {
            return "Empty";
        }

        StringBuilder itemsDescription = new StringBuilder("[");

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            itemsDescription.append(item.getName()).append("(").append(item.getOccupiedSlots()).append(")");
            if (i < items.size() - 1) { /*Se l'oggetto corrente non è l'ultimo nella lista, il metodo aggiungerà una virgola */
                itemsDescription.append(", ");
            }
        }

        itemsDescription.append("]");
        return itemsDescription.toString();
    }

    public static String getAnimalsListDescriptionString(List<Animal> animals) {
        if (animals.isEmpty()) {
            return "Empty";
        }

        StringBuilder animalsDescription = new StringBuilder("[");

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            animalsDescription.append(animal.getName());
            if (i < animals.size() - 1) {
                animalsDescription.append(", ");
            }
        }
        animalsDescription.append("]");
        return animalsDescription.toString();
    }

    public static String getDirectionsListDescriptionString(List<Direction> directions) {
        if (directions.isEmpty()) {
            return "Empty";
        }
        StringBuilder doorsDescription = new StringBuilder("[");

        for (int i = 0; i < directions.size(); i++) {
            Direction direction = directions.get(i);
            doorsDescription.append(direction.getName());
            if (i < directions.size() - 1) {
                doorsDescription.append(", ");
            }
        }
        doorsDescription.append("]");
        return doorsDescription.toString();
    }
}

