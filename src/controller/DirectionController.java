package controller;

import domain.Direction;

public class DirectionController {
    public static void main(String[] args) {
        Direction west = Direction.WEST;
        Direction north = Direction.NORTH;
        Direction south = Direction.SOUTH;
        Direction east = Direction.EAST;
        Direction nullable = Direction.NULLABLE;


       System.out.println(west.getName());
       System.out.println(Direction.correspondingDirection("ciao"));
    }
}
