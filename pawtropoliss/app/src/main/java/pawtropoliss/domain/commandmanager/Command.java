package pawtropoliss.domain.commandmanager;

public enum Command {
LOOK ("Look"),
    GO ("Go"),

    GET ("Get"),
    DROP("Drop"),
    BAG("Bag"),
    QUIT_GAME("Quit game");
    private final String nameCommand;

    Command(String nameCommand) {
        this.nameCommand=nameCommand;
    }

    @Override
    public String toString() {
        return "Command: " +
                "nameCommand: " + nameCommand + '\''
                + super.toString();
    }
}
