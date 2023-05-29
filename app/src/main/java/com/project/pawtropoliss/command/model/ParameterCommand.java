package com.project.pawtropoliss.command.model;
import org.springframework.stereotype.Component;

@Component
public class ParameterCommand {

    private static String parameter;

    private ParameterCommand() {
    }

    public static String getParameter() {
        return parameter;
    }

    public static void setParameter(String value) {
        parameter = value;
    }
}
