package domain;
 public enum Direction {
     /*insieme di valori costanti, accetta valori null, utilizzo come chiave le direzioni*/
        NORTH("North"),
        SOUTH("South"),
        EAST("East"),
        WEST("West"),
        CENTRAL("CurrentRoom"),
        NULLABLE(null);

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
            return NULLABLE;
        }

     @Override
     public String toString() {
         return "Direction --> " +
                 "name --> " + name + '\'' + super.toString();
     }
 }

