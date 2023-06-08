package com.project.pawtropoliss.command.model;
import com.project.pawtropoliss.game.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends Command {

    @Autowired
    public LookCommand(GameController gameController){
        super(gameController);
    }
    @Override
    public void execute() {
        System.out.println(getGameController().getMapController().look());
    }

}
