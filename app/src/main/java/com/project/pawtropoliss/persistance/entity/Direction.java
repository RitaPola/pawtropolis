package com.project.pawtropoliss.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {
    NORTH("North"),
    SOUTH("South"),
    EAST("East"),
    WEST("West"),
    INVALID(null);

    private final String name;
    public static Direction fromString(String name) {
        for (Direction direction : Direction.values()) {
            if (direction.name.equalsIgnoreCase(name)) {
                return direction;
            }
        }
        return INVALID;
    }

}

