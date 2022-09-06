package com.ericsHouse.jsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RoomZeroPrompts {
    static File roomZeroPrompts = new File("../22SDE05-EscapeEric/resources/roomZeroPrompts.json");
    static ObjectMapper objectMapper = new ObjectMapper();
    static JsonNode jsonNode;

    static {
        try {
            jsonNode = objectMapper.readTree(roomZeroPrompts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void roomZeroPrompt(String prompt) {
        System.out.println(jsonNode.findValue(prompt).asText());
    }
}
