package com.project.pawtropoliss.game.input;

import com.project.pawtropoliss.map.model.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
 public final class InputController {
  private final Scanner input;
 @Autowired
  public InputController() {
   input = new Scanner(System.in);
  }

  public String getInputString(String prompt) {
   System.out.print(prompt);
   return input.nextLine().trim();
  }
  public Direction getInputDirection(String prompt) {
   boolean validInput = false;
   Direction direction = null;
   while (!validInput) {
    System.out.print(prompt);
    String directionInput = input.nextLine().trim().toUpperCase();
    try {
     direction = Direction.valueOf(directionInput);
     validInput = true;
    } catch (IllegalArgumentException e) {
     System.out.println("Invalid input. Please enter one of the following directions: NORTH, SOUTH, EAST, or WEST.");
    }
   }
   return direction;
  }
  public String getInputItemName(String prompt) {
   boolean validInput = false;
   String itemName = null;
   while (!validInput) {
    System.out.print(prompt);
    itemName = input.nextLine().trim();
    if (!itemName.isEmpty()) {
     validInput = true;
    } else {
     System.out.println("Invalid input. Please enter a non-empty item name.");
    }
   }
   return itemName;
  }
 }











