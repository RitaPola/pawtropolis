package controller;

import domain.Direction;

public class DirectionController {
    public static void main(String[] args) {
        Direction west = Direction.WEST;
        Direction north = Direction.NORTH;
        Direction south = Direction.SOUTH;
        Direction east = Direction.EAST;
        Direction current = Direction.CENTRAL;
        Direction nullable = Direction.NULLABLE;


       System.out.println(current.getName());
       System.out.println(Direction.correspondingDirection("ciao"));
    }
}
