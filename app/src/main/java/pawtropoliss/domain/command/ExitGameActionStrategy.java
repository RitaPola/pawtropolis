package pawtropoliss.domain.command;

public class ExitGameActionStrategy implements ActionStrategy {

    public boolean quitGame;

    public void execute() {
        quitGame = true;
        System.exit(0);
    }
}

