package mapcontroller;

public enum Direction {
    /*insieme di valori costanti, accetta valori null, utilizzo come chiave le direzioni*/
    NORTH("North"),
    SOUTH("South"),
    EAST("East"),
    WEST("West"),
    INVALID(null);

    private final String name;


    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*restituisce una direzione corrispondente alla stringa specificata come parametro*/
    public static Direction correspondingDirection(String s) {
        for (Direction d : Direction.values()) {
            if (s.equalsIgnoreCase(d.getName())) {
                return d;
            }
        }
        return INVALID;
    }
    public Direction getOppositeDirection() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            default:
                return INVALID;
        }
    }

    @Override
    public String toString() {
        return "Direction --> " +
                "name --> " + name + '\'' + super.toString();
    }
}

