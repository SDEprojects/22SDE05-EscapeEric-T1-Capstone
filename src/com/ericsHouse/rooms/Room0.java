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


public class Room0 {

    public static String room = "RoomZero";

    public static String roomName = RoomZeroParser.getName(room);
    public static ArrayNode items = RoomZeroParser.getItems(room);
    public static ArrayList roomItems = new ObjectMapper().convertValue(items, ArrayList.class);

    public static void gameLogic() throws IOException {
        RoomZeroParser.getPrompt("gameStart");
        System.out.println("\nA small floating figure appears in front of you.");
        RoomZeroParser.getPrompt("askShaq");

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
        if (roomItems.contains("note")) {
            RoomZeroParser.getPrompt("inspectLeft");
            David.addBackpack("note");
            roomItems.remove("note");
        } else {
            RoomZeroParser.getPrompt("inspectLeftEmpty");
        }
        playerAction();
    }

    public static void inspectRight() throws IOException {
        RoomZeroParser.getPrompt("inspectRight");
        playerAction();
    }

    public static void inspectFloor() throws IOException {
        RoomZeroParser.getPrompt("inspectFloor");
        playerAction();
    }

    public static void moveToNextRoom() throws IOException {
        if (David.getBackpack().contains("note")) {
            RoomZeroParser.getPrompt("openDoorUnlocked");
        } else {
            RoomZeroParser.getPrompt("openDoorLocked");
            playerAction();
        }
    }

    public static void askShaq() throws IOException {
        RoomZeroParser.getPrompt("askShaq");
        playerAction();
    }

    public static void invalidCommand() throws IOException {
        RoomZeroParser.getPrompt("invalidCommand");
        playerAction();
    }
}
