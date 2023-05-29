package com.project.pawtropoliss.command.model;
import com.project.pawtropoliss.game.GameController;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public abstract class Command {

    private GameController gameController;

    @Autowired
    protected Command(GameController gameController){
        this.gameController = gameController;
    }
    public abstract void execute();

}
