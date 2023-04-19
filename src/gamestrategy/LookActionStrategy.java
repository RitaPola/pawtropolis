package gameStrategy;

import utils.StringUtils;
import mapcontroller.Direction;
import domain.Item;
import mapcontroller.Room;
import gestionezoo.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LookActionStrategy implements ActionStrategy {
    private Room room;

    public LookActionStrategy(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        System.out.println(room.look());
    }
}
