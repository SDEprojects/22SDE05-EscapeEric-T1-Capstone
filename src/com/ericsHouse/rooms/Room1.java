package com.ericsHouse.rooms;

import com.ericsHouse.EricHouseClient;
import com.ericsHouse.characters.David;
import com.ericsHouse.jsonParser.ActionsPrompt;
import com.ericsHouse.jsonParser.RoomZeroParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Room1 {

    public static String room = "RoomOne";
    public static RoomZeroParser currentRoom = new RoomZeroParser("roomZeroPrompts.json");
    public static String roomName = currentRoom.getName(room);
    public static ArrayNode items = currentRoom.getItems(room);
    public static ArrayList roomItems = new ObjectMapper().convertValue(currentRoom.getItems(room), ArrayList.class);

    public static void gameLogic() throws IOException {
        EricHouseClient.clearConsole();
        currentRoom.getPrompt("enterRoom");
        playerAction();
    }

    public static void playerAction() throws IOException {
        EricHouseClient.clearConsole();
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
        if (roomItems.contains("Knife")) {
            currentRoom.getPrompt("inspectLeft");
            David.addBackpack("Knife");
            roomItems.remove("Knife");
        } else {
            currentRoom.getPrompt("inspectLeftEmpty");
        }


        playerAction();
    }

    public static void inspectRight() throws IOException {
        currentRoom.getPrompt("inspectRight");
        playerAction();
    }

    public static void inspectFloor() throws IOException {
        currentRoom.getPrompt("inspectFloor");
        playerAction();
    }

    public static void moveToNextRoom() throws IOException {
        if (David.getBackpack().contains("Knife")) {
            currentRoom.getPrompt("openDoorUnlocked");
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




