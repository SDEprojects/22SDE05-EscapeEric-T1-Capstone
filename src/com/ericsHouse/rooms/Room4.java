package com.ericsHouse.rooms;

import com.ericsHouse.characters.David;
import com.ericsHouse.jsonParser.ActionsPrompt;
import com.ericsHouse.jsonParser.RoomFourParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class Room4 {
    public static String room = "RoomFour";

    public static String roomName = RoomFourParser.getName(room);
    public static ArrayNode items = RoomFourParser.getItems(room);
    public static ArrayList roomItems = new ObjectMapper().convertValue(items, ArrayList.class);

    public static void gameLogic() throws IOException {
        RoomFourParser.getPrompt("enterRoom");
        playerAction();
    }

    public static void playerAction() throws IOException {
        System.out.println("\nCurrent Room: " + roomName);
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
        RoomFourParser.getPrompt("inspectLeft");
        playerAction();
    }

    public static void inspectRight() throws IOException {
        RoomFourParser.getPrompt("inspectRight");
        playerAction();
    }

    public static void inspectFloor() throws IOException {
        if (roomItems.contains("Key")){
            RoomFourParser.getPrompt("inspectFloor");
        David.addBackpack("Key");
        roomItems.remove("Key");
    } else {
        RoomFourParser.getPrompt("inspectFloorEmpty");
    }
        playerAction();
    }

    public static void moveToNextRoom() throws IOException {
        if (David.getBackpack().contains("Key")) {
            RoomFourParser.getPrompt("openDoorUnlocked");
        } else {
            RoomFourParser.getPrompt("openDoorLocked");
            playerAction();
        }
    }

    public static void askShaq() throws IOException {
        RoomFourParser.getPrompt("askShaq");
        playerAction();
    }

    public static void invalidCommand() throws IOException {
        RoomFourParser.getPrompt("invalidCommand");
        playerAction();
    }
}
