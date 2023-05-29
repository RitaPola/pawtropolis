package com.project.pawtropoliss.command.model;
import com.project.pawtropoliss.game.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class QuitGameCommand extends Command {
    @Autowired
    public QuitGameCommand(GameController gameController){
        super(gameController);
    }

    public void execute() {
    getGameController().quitGame();
    System.out.println("Grazie " + getGameController ().getPlayer ().getName () + " per aver giocato :)");
    System.exit ( 0 );
    }
}

