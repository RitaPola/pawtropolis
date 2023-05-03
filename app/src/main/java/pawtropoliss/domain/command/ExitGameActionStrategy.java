package pawtropoliss.domain.command;


import pawtropoliss.controller.game.GameController;
import pawtropoliss.domain.game.Player;


public class ExitGameActionStrategy implements ActionStrategy {

    public ExitGameActionStrategy(){
    }
    public void execute(){
          System.out.println("\n" + "thanks for playing! \n" );
          System.exit(0);
    }
}

