package com.project.pawtropoliss.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
public enum CommandManager {
LOOK ("Look"),
    GO ("Go"),
    GET ("Get"),
    DROP("Drop"),
    BAG("Bag"),
    QUIT("Quit");
    private final String nameCommand;

    @Override
    public String toString() {
        return "Command: " +
                "nameCommand: " + nameCommand + '\''
                + super.toString();
    }
}
