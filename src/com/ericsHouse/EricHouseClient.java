package com.ericsHouse;

import com.ericsHouse.prompts.*;
import com.ericsHouse.rooms.Rooms;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EricHouseClient {
    // AB#144 might make a userInputValidation method

    // ask questions about AB145-148
    public static void main(String[] args) throws NoSuchMethodException, IOException {
        // AB#139 & 142 & 143 players can make choices e.g. ask shaq, inspect left/right, etc
        Map<Character, Method> actions = new HashMap<>();
        actions.put('0', Rooms.class.getMethod("quit"));
        actions.put('1', Rooms.class.getMethod("inspectLeft"));
        actions.put('2', Rooms.class.getMethod("inspectRight"));
        actions.put('3', Rooms.class.getMethod("inspectFloor"));
        actions.put('4', Rooms.class.getMethod("moveToNextRoom"));
        actions.put('5', Rooms.class.getMethod("askShaq"));

        while (true) {
            // AB#133 On game start, display title screen prompt
            TitleScreen.titleScreen();

            // AB#135-136 players choose to play a new game or quit
            System.out.println("\nWould you like to play a new game? Press y/n ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println("congrats you are now playing the game.");
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
