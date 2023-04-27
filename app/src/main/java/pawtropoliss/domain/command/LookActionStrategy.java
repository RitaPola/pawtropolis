package pawtropoliss.domain.command;


import pawtropoliss.domain.game.Room;


public class LookActionStrategy implements ActionStrategy {
    private final Room room;

    public LookActionStrategy(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        System.out.println(room.look());
    }
}
