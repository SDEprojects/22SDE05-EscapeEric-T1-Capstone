package com.ericsHouse.jsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class ActionsPrompt {
    public static void actionsPrompt() throws IOException {
        // AB#137-140  player can get help by typing "help" or "h" / this will display the commands
        InputStream iStreamActions = getFileFromResourceAsStream();
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

    private static InputStream getFileFromResourceAsStream() {
        ClassLoader classLoader = RoomZeroParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("actionsPrompt.json");
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + "actionsPrompt.json");
        } else {
            return inputStream;
        }
    }
}
