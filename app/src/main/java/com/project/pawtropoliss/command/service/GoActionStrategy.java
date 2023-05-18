package com.project.pawtropoliss.command.service;

import com.project.pawtropoliss.map.model.Direction;
import lombok.AllArgsConstructor;
import com.project.pawtropoliss.map.MapController;

import com.project.pawtropoliss.map.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GoActionStrategy implements ActionStrategy {
    private final MapController map;
    private Direction direction;

    @Autowired
    public GoActionStrategy(MapController map) {
        this.map = map;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void execute() {
        boolean isRoomChanged = map.changeRoom(direction);
        if (!isRoomChanged) {
            System.out.println(" There's no room in that direction. \n");
        } else {
            Room nextRoom = map.getCurrentRoom();
            System.out.println(nextRoom.look());
        }
    }
}
