package pawtropoliss.domain.command;


import lombok.AllArgsConstructor;
import pawtropoliss.domain.game.Room;

@AllArgsConstructor
public class LookActionStrategy implements ActionStrategy {
    private final Room room;
    @Override
    public void execute() {
        System.out.println(room.look());
    }
}
