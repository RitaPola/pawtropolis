package com.project.pawtropoliss.map.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum Direction {
    /*insieme di valori costanti, accetta valori null, utilizzo come chiave le direzioni*/
    NORTH("North"),
    SOUTH("South"),
    EAST("East"),
    WEST("West"),
    INVALID(null);

    private final String name;
}

