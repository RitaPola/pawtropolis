package com.project.pawtropoliss.command.model;
import com.project.pawtropoliss.command.CommandType;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {
    private final ApplicationContext context;

    public CommandFactory(ApplicationContext context) {
        this.context = context;
    }
    public Command commandAction(CommandType typeCommand, String parameter) {
        Class<? extends Command> commandClass = typeCommand.getCommandClass();
        if (commandClass != null) {
            Command command = context.getBean(commandClass);
            if (command instanceof ParameterCommand && parameter != null) {
                ((ParameterCommand) command).setParameter(parameter);
            }
            return command;
        } else {
            System.out.println("Invalid command type.");
            return null;
        }
    }
}