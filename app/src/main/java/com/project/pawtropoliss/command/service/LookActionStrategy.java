package com.project.pawtropoliss.command.service;


import lombok.AllArgsConstructor;
import com.project.pawtropoliss.map.model.Room;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LookActionStrategy implements ActionStrategy {
    private final Room room;
    @Override
    public void execute() {
        System.out.println(room.look());
    }
}
