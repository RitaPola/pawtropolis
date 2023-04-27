package pawtropoliss.controller.input;

import pawtropoliss.domain.mapmanager.Direction;
import java.util.Scanner;


 public final class InputController {

  private final Scanner input;

  public InputController() {
   input = new Scanner(System.in);
  }

  public String getInputString(String prompt) {
   System.out.print(prompt);
   return input.nextLine().trim();
  }

  public int getInputInt(String prompt, int min, int max) {
   int num = 0;
   boolean isValidInput = false;
   do {
    System.out.print(prompt);
    if (input.hasNextInt()) {
     num = input.nextInt();
     input.nextLine();
     if (num >= min && num <= max) {
      isValidInput = true;
     } else {
      System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
     }
    } else {
     String invalidInput = input.nextLine();
     System.out.println("Invalid input: " + invalidInput);
    }
   } while (!isValidInput);

   return num;
  }

  public Direction getInputDirection(String prompt) {
   Direction direction = null;
   boolean validInput;
   do {
    System.out.print(prompt);
    String directionInput = input.nextLine().trim().toUpperCase();
    try {
     direction = Direction.valueOf(directionInput);
     validInput = true;
    } catch (IllegalArgumentException e) {
     System.out.println("Invalid input. Please enter one of the following directions: NORTH, SOUTH, EAST, or WEST.");
     validInput = false;
    }
   } while (!validInput);
   return direction;
  }


  public String getInputItemName(String prompt) {
   while (true) {
    System.out.print(prompt);
    String itemName = input.nextLine().trim();
    if (itemName.length() > 0) {
     return itemName;
    }
    System.out.println("Invalid input. Please enter a non-empty item name.");
   }
  }
 }











