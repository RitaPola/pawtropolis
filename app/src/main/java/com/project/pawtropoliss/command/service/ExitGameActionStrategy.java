package com.project.pawtropoliss.command.service;

import org.springframework.stereotype.Component;
@Component
public class ExitGameActionStrategy implements ActionStrategy {
    public boolean quitGame;

    public void execute() {
        quitGame = true;
        System.exit(0);
    }
}

