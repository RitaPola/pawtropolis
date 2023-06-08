package com.project.pawtropoliss.command.model;
import com.project.pawtropoliss.game.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParameterCommand extends Command{

    private String parameter;

    @Autowired
    ParameterCommand(GameController gameController) {
        super(gameController);
        this.parameter = " ";
    }
    public String getParameter() {
        return parameter;
    }

    public  void setParameter(String value) {
        parameter = value;
    }

    @Override
    public void execute() {
        if (parameter.isEmpty()) {
            System.out.println("Missing parameter");
        }
    }

}