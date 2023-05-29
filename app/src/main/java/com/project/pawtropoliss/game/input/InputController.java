package com.project.pawtropoliss.game.input;

import org.springframework.stereotype.Component;
import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public final class InputController {
    private static final Scanner input = new Scanner ( System.in );

    public static String getInputString(String prompt) {
        boolean validInput = false;
        String str = null;
        while (!validInput) {
            System.out.print ( prompt );
            str = input.nextLine ().trim ();
            if (!str.isEmpty ()) {
                validInput = true;
            } else {
                System.out.println ( "Invalid input. Please enter a non-empty item name." );
            }
        }
        return str;
    }

    public static int getInputInt(String prompt) {
        System.out.print ( prompt );
        try {
            int value = input.nextInt ();
            input.nextLine ();
            return value;
        } catch (InputMismatchException e) {
            System.out.println ( "Input non valido. Inserire un numero intero." );
            input.nextLine ();
            return getInputInt ( prompt );
        }
    }
}






