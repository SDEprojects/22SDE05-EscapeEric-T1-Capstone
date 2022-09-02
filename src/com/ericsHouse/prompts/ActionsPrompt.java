package com.ericsHouse.prompts;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ActionsPrompt {
    public static void actionsPrompt() throws IOException {
        File jsonActionsPromptTest = new File("../22SDE05-EscapeEric/resources/actionsPrompt.json");

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(jsonActionsPromptTest);

        System.out.println(jsonNode.findValue("0").asText());
        System.out.println(jsonNode.findValue("1").asText());
        System.out.println(jsonNode.findValue("2").asText());
        System.out.println(jsonNode.findValue("3").asText());
        System.out.println(jsonNode.findValue("4").asText());
        System.out.println(jsonNode.findValue("5").asText());
    }
}
