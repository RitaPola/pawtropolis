package domain;
 public enum Direction {
        NORTH("north"),
        SOUTH("south"),
        EAST("east"),
        WEST("west"),
        INVALID(null);

        private final String name;

        Direction(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Direction of(String s) {
            for (Direction d : Direction.values()) {
                if (s.equalsIgnoreCase(d.getName())) {
                    return d;
                }
            }
            return INVALID;
        }
    }

