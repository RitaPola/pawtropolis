package com.project.pawtropoliss.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TypeCommand {
    CHARACTER("Character"),
    LOOK("Look"),
    GO("Go"),
    GET("Get"),
    DROP("Drop"),
    BAG("Bag"),
    QUIT("Quit"),
    INVALID(null);
    private final String nameCommand;
    public static TypeCommand type(String s) {
        return Arrays.stream(values())
                .filter(d -> s.equalsIgnoreCase(d.getNameCommand()))
                .findAny()
                .orElse(INVALID);
    }
}
