package pawtropoliss.domain.commandmanager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Command {
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
