package com.ericsHouse.rooms;

import com.ericsHouse.characters.David;
import com.ericsHouse.jsonParser.ActionsPrompt;
import com.ericsHouse.jsonParser.RoomThreeParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;


public class Room3 {

    private static final String room = "RoomThree";
    private static boolean question1Correct = false;
    private static boolean question2Correct = false;
    private static boolean question3Correct = false;


    public static String roomName = RoomThreeParser.getName(room);
    public static ArrayNode items = RoomThreeParser.getItems(room);
    public static ArrayList roomItems = new ObjectMapper().convertValue(items, ArrayList.class);

    public static void gameLogic() throws IOException {
        RoomThreeParser.getPrompt("enterRoom");
        RoomThreeParser.getPrompt("askShaq");


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
        String answer = "towel";
        RoomThreeParser.getPrompt("inspectLeft");

        Scanner scanner = new Scanner(System.in);
        if (scanner.next().toLowerCase().equals(answer)) {
            System.out.println("You have correctly answered this question");
            question1Correct = true;
        } else {
            System.out.println("You have chosen the wrong answer");
        }
        playerAction();
    }

    public static void inspectRight() throws IOException {
        String answer = "coffin";
        RoomThreeParser.getPrompt("inspectRight");

        Scanner scanner = new Scanner(System.in);
        if (scanner.next().toLowerCase().equals(answer)) {
            System.out.println("You have correctly answered this question");
            question2Correct = true;
        } else {
            System.out.println("You have chosen the wrong answer");
        }
        playerAction();
    }

    public static void inspectFloor() throws IOException {
        String answer = "david";
        RoomThreeParser.getPrompt("inspectFloor");

        Scanner scanner = new Scanner(System.in);
        if (scanner.next().toLowerCase().equals(answer)) {
            System.out.println("You have correctly answered this question");
            question3Correct = true;
        } else {
            System.out.println("You have chosen the wrong answer");
        }
        playerAction();
    }

    public static void moveToNextRoom() throws IOException {
        if (question1Correct && question2Correct && question3Correct) {
            RoomThreeParser.getPrompt("openDoorUnlocked");
        } else {
            RoomThreeParser.getPrompt("openDoorLocked");
            playerAction();
        }
    }

    public static void askShaq() throws IOException {
        RoomThreeParser.getPrompt("askShaq");
        playerAction();
    }

    public static void invalidCommand() throws IOException {
        RoomThreeParser.getPrompt("invalidCommand");
        playerAction();
    }
}
