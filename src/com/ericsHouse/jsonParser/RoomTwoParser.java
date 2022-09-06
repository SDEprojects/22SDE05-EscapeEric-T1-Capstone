package com.ericsHouse.jsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RoomTwoParser {

    public static void roomTwoPrompt(String prompt) throws IOException {
        File jsonActionsPromptTest = new File("../22SDE05-EscapeEric/resources/roomTwoPrompts.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonActionsPromptTest);

        System.out.println(jsonNode.findValue(prompt).asText());
    }

    public static void enterRoom() {
        System.out.println("\nWelcome to Room 2:\n"
                + "\nTo your left you see a table."
                + "\nTo your right you see a Desk."
                + "\nYou also see something shiny on the floor in front of you."
                + "\nStraight ahead is the locked door to the next room."
        );
    }

}
