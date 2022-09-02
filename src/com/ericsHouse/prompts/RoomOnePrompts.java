package com.ericsHouse.prompts;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RoomOnePrompts {

    public static void roomOnePrompt(String prompt) throws IOException {
        File jsonActionsPromptTest = new File("../22SDE05-EscapeEric/resources/roomOnePrompts.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonActionsPromptTest);

        System.out.println(jsonNode.findValue(prompt).asText());
    }

    public static void enterRoom() {
        System.out.println("\nWelcome to Room 1:\n"
                + "\nTo your left you see a bookshelf."
                + "\nTo your right you see a table."
                + "\nStraight ahead is the locked door to the next room."
        );
    }

}
