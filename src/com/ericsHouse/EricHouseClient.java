package com.ericsHouse;

import com.ericsHouse.characters.David;
import com.ericsHouse.jsonParser.*;
import com.ericsHouse.rooms.Room0;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.Scanner;



public class EricHouseClient {

    public static String currentRoom = "";
    // AB#144 might make a userInputValidation method

    // ask questions about AB145-148
    public static void main(String[] args) throws IOException {
        // AB#139 & 142 & 143 players can make choices e.g. ask shaq, inspect left/right, etc

        David david = new David();
        david.getBackpack().add("item");

        while (true) {
            // AB#133 On game start, display title screen prompt
            TitleScreen.titleScreen();

            // AB#135 players choose to play a new game or not
            System.out.println("\nWould you like to play a new game? Press y/n ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                break;
            } else {
                Room0.gameLogic();
            }

            // AB#134 introduce the game to the players

            // AB#137-140  player can get help by typing "help" or "h" / this will display the commands

            // AB#141 player should be able to see where they currently are, display the challenge

            // AB#135-136 when the game is over, ask if the player wants to play again or quit
//            System.out.println("Game Over! Do you want to play again? Press y/n ");
            answer = scanner.next();
            if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                break;
            }
        }

    }
}
