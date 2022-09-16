package com.ericsHouse;

import com.ericsHouse.jsonParser.*;
import com.ericsHouse.rooms.*;

import java.io.IOException;
import java.util.Scanner;



public class EricHouseClient {
    public static int chancesRemaining = 5;

    public static void ericAppearsCheck() {
        chancesRemaining -= 1;
        // figure out how to make this start the game over, instead of just killing the entire process
        if (chancesRemaining == 0) {
            RoomZeroParser.getPrompt("ericAppears");
            System.exit(0);
        }
    }

    public static void clearConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n<Hit Enter To Continue>");
        String readString = scanner.nextLine();
        if (readString.equals("")) {
            try {
                final String os = System.getProperty("os.name");
                if (os.contains("Windows")) {
                    ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                    Process startProcess = pb.inheritIO().start();
                    startProcess.waitFor();
                } else {
                    ProcessBuilder pb = new ProcessBuilder("clear");
                    Process startProcess = pb.inheritIO().start();
                    startProcess.waitFor();
                }
            } catch (final Exception e) {
                System.out.println("Couldn't refresh the console");
            }
        } else {
            clearConsole();
        }
    }

    // AB#144 might make a userInputValidation method

    // ask questions about AB145-148
    public static void main(String[] args) throws IOException {
        // AB#139 & 142 & 143 players can make choices e.g. ask shaq, inspect left/right, etc

        while (true) {
            // AB#133 On game start, display title screen prompt
            // AB#134 introduce the game to the players
            TitleScreen.titleScreen();

            // AB#135 players choose to play a new game or not
            System.out.println("\nWould you like to start the game? Press y/n ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                break;
            } else {
                //Room0.gameLogic();

            }

            // AB#141 player should be able to see where they currently are, display the challenge

            // AB#135-136 when the game is over, ask if the player wants to play again or quit
            System.out.println("Game Over! Do you want to play again? Press y/n ");
            answer = scanner.next();
            if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                break;
            }
        }
    }
}
