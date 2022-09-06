package com.ericsHouse.rooms;

import com.ericsHouse.jsonParser.ActionsPrompt;
import com.ericsHouse.jsonParser.RoomZeroParser;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.Scanner;


public class Room0 {

    public static String room = "RoomTwo";

    public static void gameLogic() throws IOException {
        RoomZeroParser.getPrompt("gameStart");
        System.out.println("\nA small floating figure appears in front of you.\n");
        RoomZeroParser.getPrompt("askShaq");

        String roomName = RoomZeroParser.getName(room);
        ArrayNode items = RoomZeroParser.getItems(room);
        System.out.println(roomName);
        System.out.println(items);


        playerAction();


    }

    public static void playerAction() throws IOException {
        while (true) {
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
            }
        }
    }



    public static void quit() {
        System.exit(0);
    }

    public static void inspectLeft() throws IOException {
        RoomZeroParser.getPrompt("inspectLeft");
        // add item found to player inventory.
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
        //make conditional to handle challenge for room and lock/unlock door;
        RoomZeroParser.getPrompt("openDoorLocked");
        playerAction();
    }


    public static void askShaq() throws IOException {
        RoomZeroParser.getPrompt("askShaq");
        playerAction();
    }

}
