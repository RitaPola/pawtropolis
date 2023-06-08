package com.project.pawtropoliss.command;

import com.project.pawtropoliss.command.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum CommandType {
    BAG(BagCommand.class),
    GO(GoCommand.class),
    GET(GetCommand.class),
    DROP(DropCommand.class),
    LOOK(LookCommand.class),
    CHARACTER(PlayerCharacterCommand.class),
    QUIT(QuitGameCommand.class),
    INVALID(null);

    private final Class<? extends Command> commandClass;

    public static CommandType type(String s) {
        return Arrays.stream(values())
                .filter(d -> s.equalsIgnoreCase(d.name()))
                .findAny()
                .orElse(INVALID);
    }
}
