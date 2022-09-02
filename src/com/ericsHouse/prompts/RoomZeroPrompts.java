package com.ericsHouse.prompts;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RoomZeroPrompts {


    public static void roomZeroPrompt(String prompt) throws IOException {
        File jsonActionsPromptTest = new File("../22SDE05-EscapeEric/resources/roomZeroPrompts.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonActionsPromptTest);

        System.out.println(jsonNode.findValue(prompt).asText());
    }

    public static void gameStartPrompt() {
        System.out.println("\nYou awaken to find yourself in a strange room..."
                + "\nYou have no idea where you are or how you got here."
                + "\nYou rub your eyes and look around to see the room only has one door."
                + "\nOn the left side of the room is a small table with what seems to be a note sitting on it."
        );
    }

    public static void readNote() {
        System.out.println("\nWelcome to Eric's house!"
                + "\nFind your way through the rooms to escape. Each room has a locked door "
                + "\nthat will take you to the next room. It can be unlocked by solving the "
                + "\nchallenge of that room.\n"
                + "\nOh… I almost forgot…\n"
                + "\nEric is also here and he’s looking for you. "
                + "\nIt would be in your best interest to not let him find you. "
                + "\nThe more attempts it takes to solve a challenge the more likely it is "
                + "\nhe stumbles into the same room.\n"
                + "\nGOOD LUCK!"
        );
    }

}
