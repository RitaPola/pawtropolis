package com.project.pawtropoliss.command.model;
import com.project.pawtropoliss.command.TypeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {
    private final ApplicationContext context;

    @Autowired
    public CommandFactory(ApplicationContext context){
        this.context=context;
    }
    public Command commandAction(TypeCommand typeCommand) {
        switch (typeCommand) {
            case BAG -> {
                return context.getBean(BagCommand.class);
            }
            case GO -> {
                return context.getBean(GoCommand.class);
            }
            case GET -> {
                return context.getBean(GetCommand.class);
            }
            case DROP -> {
                return context.getBean(DropCommand.class);
            }
            case LOOK -> {
                return context.getBean(LookCommand.class);
            }
            case CHARACTER -> {
                return context.getBean(PlayerCharacterCommand.class);
            }
            case QUIT -> {
                return context.getBean(QuitGameCommand.class);
            }
            default -> {
                System.out.println("Invalid command type.");
                return null;
            }
        }
    }
}


