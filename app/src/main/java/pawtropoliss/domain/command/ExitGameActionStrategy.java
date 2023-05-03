package pawtropoliss.domain.command;


import pawtropoliss.controller.game.GameController;
import pawtropoliss.domain.game.Player;


public class ExitGameActionStrategy implements ActionStrategy {

    public ExitGameActionStrategy(){
    }
    public void execute(){
        GameController.getInstance().playerQuit();
    }
}

