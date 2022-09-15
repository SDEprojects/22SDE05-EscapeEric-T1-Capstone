package com.ericsHouse.rooms;

import com.ericsHouse.EricHouseClient;
import com.ericsHouse.characters.David;
import com.ericsHouse.jsonParser.ActionsPrompt;
import com.ericsHouse.jsonParser.RoomZeroParser;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.Scanner;


public class Room3 {

    private static final String room = "RoomThree";
    public static RoomZeroParser currentRoom = new RoomZeroParser("roomZeroPrompts.json");
    private static boolean question1Correct = false;
    private static boolean question2Correct = false;
    private static boolean question3Correct = false;


    public static String roomName = currentRoom.getName(room);
    public static ArrayNode items = currentRoom.getItems(room);

    public static void gameLogic() throws IOException {
        currentRoom.getPrompt("enterRoom");

        playerAction();
    }

    public static void playerAction() throws IOException {
        EricHouseClient.clearConsole();

        System.out.println("\nCurrent Room: " + roomName);
        System.out.println("Eric is " + EricHouseClient.chancesRemaining + " rooms away");
        System.out.println("David's Backpack: " + David.getBackpack());
        System.out.println("\nWhat would you like to do?");
        ActionsPrompt.actionsPrompt();

        Scanner scanner = new Scanner(System.in);
        String nextAction = scanner.next();
        if (nextAction.equalsIgnoreCase("0")) {
            quit();
        } else if (nextAction.equalsIgnoreCase("1")) {
            inspectLeft();
        } else if (nextAction.equalsIgnoreCase("2")) {
            inspectRight();
        } else if (nextAction.equalsIgnoreCase("3")) {
            inspectFloor();
        } else if (nextAction.equalsIgnoreCase("4")) {
            moveToNextRoom();
        } else if (nextAction.equalsIgnoreCase("5")) {
            askShaq();
        } else {
            invalidCommand();
        }
    }

    public static void quit() {
        System.exit(0);
    }

    public static void inspectLeft() throws IOException {
        String answer = "towel";
        currentRoom.getPrompt("inspectLeft");

        Scanner scanner = new Scanner(System.in);
        if (scanner.next().toLowerCase().equals(answer)) {
            currentRoom.getPrompt("inspectLeftCorrect");
            question1Correct = true;
        } else {
            EricHouseClient.ericAppearsCheck();
            currentRoom.getPrompt("inspectLeftHint");
        }
        playerAction();
    }

    public static void inspectRight() throws IOException {
        String answer = "coffin";
        currentRoom.getPrompt("inspectRight");

        Scanner scanner = new Scanner(System.in);
        if (scanner.next().toLowerCase().equals(answer)) {
            currentRoom.getPrompt("inspectRightCorrect");
            question2Correct = true;
        } else {
            EricHouseClient.ericAppearsCheck();
            currentRoom.getPrompt("inspectRightHint");
        }
        playerAction();
    }

    public static void inspectFloor() throws IOException {
        String answer = "david";
        currentRoom.getPrompt("inspectFloor");

        Scanner scanner = new Scanner(System.in);
        if (scanner.next().toLowerCase().equals(answer)) {
            currentRoom.getPrompt("inspectFloorCorrect");
            question3Correct = true;
        } else {
            EricHouseClient.ericAppearsCheck();
            currentRoom.getPrompt("inspectFloorHint");
        }
        playerAction();
    }

    public static void moveToNextRoom() throws IOException {
        if (question1Correct && question2Correct && question3Correct) {
            currentRoom.getPrompt("openDoorUnlocked");
            question1Correct = false;
            question2Correct = false;
            question3Correct = false;
        } else {
            currentRoom.getPrompt("openDoorLocked");
            playerAction();
        }
    }

    public static void askShaq() throws IOException {
        currentRoom.getPrompt("askShaq");
        playerAction();
    }

    public static void invalidCommand() throws IOException {
        currentRoom.getPrompt("invalidCommand");
        playerAction();
    }
}
