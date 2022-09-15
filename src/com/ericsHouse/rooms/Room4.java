package com.ericsHouse.rooms;

import com.ericsHouse.EricHouseClient;
import com.ericsHouse.characters.David;
import com.ericsHouse.jsonParser.ActionsPrompt;
import com.ericsHouse.jsonParser.RoomZeroParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Room4 {
    public static String room = "RoomFour";
    public static RoomZeroParser currentRoom = new RoomZeroParser("roomZeroPrompts.json");
    public static int playerWins = 0;
    public static int doorWins = 0;

    public static String roomName = currentRoom.getName(room);
    public static ArrayNode items = currentRoom.getItems(room);
    static ArrayList<String> anvilMaterial = new ArrayList<>();
    static ArrayList<String> anvilTool = new ArrayList<>();
    public static ArrayList roomItems = new ObjectMapper().convertValue(items, ArrayList.class);

    public static void gameLogic() throws IOException {
        currentRoom.getPrompt("enterRoom");
        playerAction();
    }

    public static void playerAction() throws IOException {
        EricHouseClient.clearConsole();
        System.out.println("\nCurrent Room: " + roomName);
        System.out.println("Eric is " + EricHouseClient.chancesRemaining + " rooms away");
        System.out.println("David's Backpack: " + David.getBackpack());
        System.out.println("David is wearing: " + David.getWornItems());
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
        if (roomItems.contains("Mirrored Glasses")) {
            currentRoom.getPrompt("inspectLeft");
            David.addWornItems("Mirrored Glasses");
            roomItems.remove("Mirrored Glasses");
        } else {
            currentRoom.getPrompt("inspectLeftEmpty");
        }
        playerAction();
    }

    public static void inspectRight() throws IOException {
        if (roomItems.contains("Paper")) {
            currentRoom.getPrompt("inspectRight");
            David.addBackpack("Paper");
            David.addBackpack("SheetMetal");
            David.addBackpack("Wrench");
            roomItems.remove("Paper");
            roomItems.remove("SheetMetal");
            roomItems.remove("Wrench");
        } else {
            currentRoom.getPrompt("inspectRightEmpty");
        }
        playerAction();
    }

    public static void inspectFloor() throws IOException {
        currentRoom.getPrompt("inspectFloor");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            craftItem();
            playerAction();
        } else {
            playerAction();
        }
    }

    public static void moveToNextRoom() throws IOException {
        if (David.getWornItems().contains("Metal Hat") && David.getWornItems().contains("Mirrored Glasses")) {
            currentRoom.getPrompt("openDoorLocked");
            RPSFair();
        } else {
            currentRoom.getPrompt("openDoorLocked");
            RPSUnfair();
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

    public static void craftItem() {
        System.out.println("What tool would you like to use: ");
        Scanner scanner = new Scanner(System.in);
        String tool = scanner.next();
        anvilTool.add(tool);

        System.out.println("What material would you like to craft: ");
        String material = scanner.next();
        anvilMaterial.add(material);

        if (anvilTool.contains("Hammer") && anvilMaterial.contains("SheetMetal")) {
            currentRoom.getPrompt("inspectFloorCraftHat");
            David.addWornItems("Metal Hat");
            David.removeBackpack("SheetMetal");
            anvilMaterial.clear();
            anvilTool.clear();
        } else if (anvilMaterial.contains("Paper")) {
            currentRoom.getPrompt("inspectFloorCraftAirplane");
            David.removeBackpack("Paper");
            anvilMaterial.clear();
            anvilTool.clear();
        } else {
            currentRoom.getPrompt("inspectFloorCraftFail");
        }
    }

    public static void RPSFair() throws IOException {
        while (doorWins != 2 && playerWins != 2) {
            System.out.println("\nType your next move: rock, paper, or scissors: ");
            Scanner scanner = new Scanner(System.in);
            String playerMove = scanner.nextLine();

            Random random = new Random();
            int randomNumber = random.nextInt(3);

            String computerMove;
            if (randomNumber == 0) {
                computerMove = "rock";
            } else if (randomNumber == 1) {
                computerMove = "paper";
            } else {
                computerMove = "scissors";
            }
            System.out.println("\nDoor chooses " + computerMove + ".");

            if (playerMove.equals(computerMove)) {
                System.out.println("\nDraw.");
            } else if (doesPlayerWin(playerMove, computerMove)) {
                System.out.println("\nYou win.");
                playerWins++;
                System.out.println("Player Wins: " + playerWins);
            } else {
                System.out.println("\nDoor wins!");
                doorWins++;
                System.out.println("Door wins: " + doorWins);
            }
        }
        if (doorWins == 2) {
            currentRoom.getPrompt("openDoorLockedLoser");
            EricHouseClient.ericAppearsCheck();
            doorWins = 0;
            playerWins = 0;
            playerAction();
        } else if (playerWins == 2) {
            currentRoom.getPrompt("openDoorUnlocked");
        }
    }

    public static boolean doesPlayerWin(String playerMove, String computerMove) {
        if (playerMove.equals("rock")) {
            return computerMove.equals("scissors");
        } else if (playerMove.equals("paper")) {
            return computerMove.equals("rock");
        } else {
            return computerMove.equals("paper");
        }
    }

    public static void RPSUnfair() throws IOException {
        while (doorWins < 2) {
            System.out.println("\nType your next move: Rock, Paper, or Scissors: ");
            Scanner scanner = new Scanner(System.in);
            String playerMove = scanner.next();
            if (playerMove.equalsIgnoreCase("Rock")) {
                System.out.println("\nDoor chooses Paper. Door wins.");
                doorWins++;
            } else if (playerMove.equalsIgnoreCase("Paper")) {
                System.out.println("\nDoor chooses Scissors. Door wins.");
                doorWins++;
            } else if (playerMove.equalsIgnoreCase("Scissors")) {
                System.out.println("\nDoor chooses Rock. Door wins.");
                doorWins++;
            } else {
                System.out.println("\nThat's not a valid move. Try again.");
            }
        }
        currentRoom.getPrompt("openDoorLockedLoser");
        EricHouseClient.ericAppearsCheck();
        doorWins = 0;
        playerWins = 0;
        playerAction();
    }
}
