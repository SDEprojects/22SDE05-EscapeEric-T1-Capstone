package com.ericsHouse.rooms;

import com.ericsHouse.characters.David;
import com.ericsHouse.jsonParser.ActionsPrompt;
import com.ericsHouse.jsonParser.RoomOneParser;
import com.ericsHouse.jsonParser.RoomZeroParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Room1 {

    public static String room = "RoomOne";

    public static String roomName = RoomOneParser.getName(room);
    public static ArrayList roomItems = new ObjectMapper().convertValue(RoomOneParser.getItems(room), ArrayList.class);

    public static void gameLogic() throws IOException {
        RoomOneParser.getPrompt("enterRoom");

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
        if (roomItems.contains("knife")) {
            RoomOneParser.getPrompt("inspectLeft");
            David.addBackpack("knife");
            roomItems.remove("knife");
        } else {
            RoomOneParser.getPrompt("inspectLeftEmpty");
        }


        playerAction();
    }

    public static void inspectRight() throws IOException {
        RoomOneParser.getPrompt("inspectRight");
        playerAction();
    }

    public static void inspectFloor() throws IOException {
        RoomOneParser.getPrompt("inspectFloor");
        playerAction();
    }

    public static void moveToNextRoom() throws IOException {
        if (David.getBackpack().contains("knife")) {
            RoomOneParser.getPrompt("openDoorUnlocked");
        } else {
            RoomOneParser.getPrompt("openDoorLocked");
            playerAction();
        }
    }

    public static void askShaq() throws IOException {
        RoomOneParser.getPrompt("askShaq");
        playerAction();
    }

    public static void invalidCommand() throws IOException {
        RoomZeroParser.getPrompt("invalidCommand");
        playerAction();
    }
}




