package com.ericsHouse;

import com.ericsHouse.jsonParser.*;
import com.ericsHouse.rooms.Room0;

import java.io.IOException;
import java.util.Scanner;



public class EricHouseClient {

    public static String currentRoom = "";
    // AB#144 might make a userInputValidation method

    // ask questions about AB145-148
    public static void main(String[] args) throws IOException {
        // AB#139 & 142 & 143 players can make choices e.g. ask shaq, inspect left/right, etc

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

//                currentRoom = "Room Zero";
//                RoomZeroPrompts.roomZeroPrompt("gameStart");
//                System.out.println("\nA small floating figure appears in front of you.\n");
//                RoomZeroPrompts.roomZeroPrompt("askShaq");
//                System.out.println("\nWhat would you like to do?");
//                ActionsPrompt.actionsPrompt();
//
//                Scanner scanner2 = new Scanner(System.in);
//                String nextAction = scanner2.next();
//                if (nextAction.equalsIgnoreCase("0")) {
//                    break;
//                } else if (nextAction.equalsIgnoreCase("1")) {
//                    RoomZeroPrompts.roomZeroPrompt("inspectLeft");
//                } else if (nextAction.equalsIgnoreCase("2")) {
//                    RoomZeroPrompts.roomZeroPrompt("inspectRight");
//                } else if (nextAction.equalsIgnoreCase("3")) {
//                    RoomZeroPrompts.roomZeroPrompt("inspectFloor");
//                } else if (nextAction.equalsIgnoreCase("4")) {
//                    RoomZeroPrompts.roomZeroPrompt("openDoorUnlocked");
//                } else if (nextAction.equalsIgnoreCase("5")) {
//                    RoomZeroPrompts.roomZeroPrompt("askShaq");
//                }
            }

            // AB#134 introduce the game to the players

            // AB#137-140  player can get help by typing "help" or "h" / this will display the commands


//            ActionsPrompt.actionsPrompt();
//
//            RoomZeroPrompts.roomZeroPrompt("gameStart");
//            RoomZeroPrompts.roomZeroPrompt("readNote");
//            RoomZeroPrompts.roomZeroPrompt("openDoorLocked");
//            RoomZeroPrompts.roomZeroPrompt("openDoorUnlocked");
//            RoomZeroPrompts.roomZeroPrompt("askShaq");
//
//            RoomOnePrompts.roomOnePrompt("enterRoom");
//            RoomOnePrompts.roomOnePrompt("inspectLeft");
//            RoomOnePrompts.roomOnePrompt("inspectRight");
//            RoomOnePrompts.roomOnePrompt("inspectFloor");
//            RoomOnePrompts.roomOnePrompt("openDoorLocked");
//            RoomOnePrompts.roomOnePrompt("openDoorUnlocked");
//            RoomOnePrompts.roomOnePrompt("askShaq");
//
//            RoomTwoPrompts.roomTwoPrompt("enterRoom");
//            RoomTwoPrompts.roomTwoPrompt("inspectLeft");
//            RoomTwoPrompts.roomTwoPrompt("inspectRight");
//            RoomTwoPrompts.roomTwoPrompt("inspectFloor");
//            RoomTwoPrompts.roomTwoPrompt("openDoorLocked");
//            RoomTwoPrompts.roomTwoPrompt("openDoorUnlocked");
//            RoomTwoPrompts.roomTwoPrompt("askShaq");





            // AB#141 player should be able to see where they currently are, display the challenge

            // AB#135-136 when the game is over, ask if the player wants to play again or quit
//            System.out.println("Game Over! Do you want to play again? Press y/n ");
//            Scanner scanner = new Scanner(System.in);
//            String answer = scanner.next();
//            if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
//                break;
//            }
            break;
        }

    }
}
