package gameStrategy;


import domain.Room;


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
