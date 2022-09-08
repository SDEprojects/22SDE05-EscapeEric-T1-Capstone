package com.ericsHouse.jsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class ActionsPrompt {
    public static void actionsPrompt() throws IOException {
//        File jsonActionsPromptTest = new File("../22SDE05-EscapeEric/resources/actionsPrompt.json");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        JsonNode jsonNode = objectMapper.readTree(jsonActionsPromptTest);
        InputStream iStreamActions = getFileFromResourceAsStream("actionsPrompt.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Reader readerActions = new InputStreamReader(iStreamActions);
        JsonNode jsonNode = objectMapper.readTree(readerActions);

        System.out.println(jsonNode.findValue("0").asText());
        System.out.println(jsonNode.findValue("1").asText());
        System.out.println(jsonNode.findValue("2").asText());
        System.out.println(jsonNode.findValue("3").asText());
        System.out.println(jsonNode.findValue("4").asText());
        System.out.println(jsonNode.findValue("5").asText());
    }

    private static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = RoomZeroParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            System.out.println("Found " + fileName);
            return inputStream;
        }
    }
}
