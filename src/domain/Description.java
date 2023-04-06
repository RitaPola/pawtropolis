package domain;

import gestionezoo.Animal;

import java.util.List;

public final class Description {
        public Description() {}

        public static String getItemsListDescriptionString(List<Item> items) {
            if (items.isEmpty()) {
                return "Vuoto";
            }

            String itemsDescription = "[";

            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                itemsDescription += item.getNameItem() + "(" + item.getOccupiedSlots() + ")";
                if (i < items.size() - 1) {
                    itemsDescription += ", ";
                }
            }

            itemsDescription += "]";
            return itemsDescription;
        }

        public static String getAnimalsListDescriptionString(List<Animal> animals) {
            if (animals.isEmpty()) {
                return "[]";
            }

            String animalsDescription = "[";

            for (int i = 0; i < animals.size(); i++) {
                Animal animal = animals.get(i);
                animalsDescription += animal.getName() + "(" + animal.getClass().getSimpleName() + ")";
                if (i < animals.size() - 1) {
                    animalsDescription += ", ";
                }
            }

            animalsDescription += "]";
            return animalsDescription;
        }

        public static String getDirectionsListDescriptionString(List<Direction> directions) {
            if (directions.isEmpty()) {
                return "[]";
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

