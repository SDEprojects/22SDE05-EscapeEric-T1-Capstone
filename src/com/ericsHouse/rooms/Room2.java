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


public class Room2 {

    public static String room = "RoomTwo";
    public static RoomZeroParser currentRoom = new RoomZeroParser("roomZeroPrompts.json");
    static ArrayList<String> doorInventory = new ArrayList<>();
    public static String roomName = currentRoom.getName(room);
    public static ArrayNode items = currentRoom.getItems(room);
    public static ArrayList roomItems = new ObjectMapper().convertValue(currentRoom.getItems(room), ArrayList.class);

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
            playerAction();
        }
    }



    public static void quit() {
        System.exit(0);
    }

    public static void inspectLeft() throws IOException {
        if (roomItems.contains("Onion")) {
            currentRoom.getPrompt("inspectLeft");
            David.addBackpack("Onion");
            roomItems.remove("Onion");
        } else {
            currentRoom.getPrompt("inspectLeftEmpty");
        }
        playerAction();
    }

    public static void inspectRight() throws IOException {
        if (roomItems.contains("Pencil")) {
            currentRoom.getPrompt("inspectRight");
            David.addBackpack("Hammer");
            David.addBackpack("Pencil");
            David.addBackpack("Emerald");
            roomItems.remove("Pencil");
            roomItems.remove("Emerald");
            roomItems.remove("Hammer");
        } else {
            currentRoom.getPrompt("inspectRightEmpty");
        }
        playerAction();
    }

    public static void inspectFloor() throws IOException {
        if (roomItems.contains("Needle")) {
            currentRoom.getPrompt("inspectFloor");
            David.addBackpack("Needle");
            roomItems.remove("Needle");
        } else {
            currentRoom.getPrompt("inspectFloorEmpty");
        }
        playerAction();
    }

    public static void moveToNextRoom() throws IOException {
        if (David.getBackpack().contains("Onion")
                && David.getBackpack().contains("Pencil")
                && David.getBackpack().contains("Emerald")
                && David.getBackpack().contains("Needle")) {
            currentRoom.getPrompt("openDoorLockedWithItems");
            addItemToDoor();
            if (doorInventory.indexOf("Onion") == 0
                    && doorInventory.indexOf("Pencil") == 1
                    && doorInventory.indexOf("Emerald") == 2
                    && doorInventory.indexOf("Needle") == 3) {
                currentRoom.getPrompt("openDoorUnlocked");
            } else {
                EricHouseClient.ericAppearsCheck();
                doorInventory.clear();
                currentRoom.getPrompt("openDoorLockedIncorrectOrder");
                playerAction();
            }
        } else {
            currentRoom.getPrompt("openDoorLocked");
            playerAction();
        }
    }

    public static void askShaq() throws IOException {
        currentRoom.getPrompt("askShaq");
        playerAction();
    }

    public static void invalidCommand() {
        currentRoom.getPrompt("invalidCommand");
    }

    public static void addItemToDoor() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Item " + i +":");
            Scanner scanner = new Scanner(System.in);
            String item = scanner.next();
            doorInventory.add(item);
        }
    }

}
